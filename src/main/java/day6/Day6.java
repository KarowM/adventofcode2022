package day6;

public class Day6 {

    private static final int WINDOW_SIZE = 4;

    public static void main(String[] args) {
        System.out.println("PART 1");
        day6_1();

        System.out.println();

        System.out.println("PART 2");
        day6_2();
    }

    private static void day6_1() {
        String input = getInput();

        int start = 0;
        int end = 0;
        while (end - start < WINDOW_SIZE) {
            start = getNewStart(input, start, end);
            end++;
        }

        System.out.println(end);
    }

    private static int getNewStart(String input, int start, int end) {
        char newChar = input.charAt(end);
        int tracker = end - 1;
        while (tracker >= start) {
            char c = input.charAt(tracker);
            if (c == newChar) {
                return tracker + 1;
            }
            tracker--;
        }
        return start;
    }

    private static void day6_2() {

    }

    private static String getInputExample1() {
        return "bvwbjplbgvbhsrlpgdmjqwftvncz";
    }

    private static String getInputExample2() {
        return "nppdvjthqldpwncqszvftbrmjlhg";
    }

    private static String getInputExample3() {
        return "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    }

    private static String getInputExample4() {
        return "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
    }

    private static String getInputExample5() {
        return "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    }

    private static String getInput() {
        return "vftfrfcrfrpptffhnnnsznzgngqgsssczcjcdcssmgmtmnmqnmmfttbdttqtggmgpmmqrqzrzttptpdtpddqfdffgjgzjzczjcjjvttvmmrwmrwwjtwjttnccgbcbjbgjjcvvsqshszhzvhvsstjjljcczmzjmzzdtzzhfhvvvflljtllfqqdmmmhmfhffzhhtgtssqppgcppfjjrnngwwrvrvqvpppcspsrrsqqqlmmpcmcjmmjhmhzzpnnggmjjrprptpccdggcrrwfwggsfggbbqlqflqqcsqqccqzqbbnbmmlzllnhnwwsjsgstgttfdtffzfvzvbzzrlzlppcsctcncrncnjnfnqnvngnzzscslsppdqdbbthhqvqfvqqvccvdcddsllnwnqwwsccjmcjmmfmppnzpzffslffjrfjftftrffwcwppfsftssdwdzzffnwndnvnggbbfbgfbbfmbbjzzdqdtqtfqqpzzqpzpllvrrbqqbcqqzvznzmmwcwtwftwfwtftvtddhldldblbzlbzlllcjjwllvcllqplqplpzlzqzsqzsznnqwnqqrcqqnrrhmmqbqqlbqqrhrrdgrrsqssnwsnswsgsfsbbdhbdbqqtsqsbsmmbtmmghhcththrrnvvnlvvdvwwjwmwbmmvtvztzmtmrmprpvvmbmrbrsbbpsbbtccwgccbctbccjrjcjtccrrdnnwwqrwwjpjtptcpcfpfvfjjtqtnqqvzqqfhfrftrrgqgbqqtwwthwhqwqjqmmlglnlrnlrnnshsmspmmfnnqwqgwqqprpbbjbhjbbfqftfwwjhhcpcgcpcvppgfgcfgffbzbfzbzqzccmppndppspbssnbbpdpjpgpngpnggtztjzjdjhjmmwrmmqhhcvvvltvllvmvpvlplwplpmllgpllczlzpzczwzswwqgqbqppcjjhjddgccfmmctcjcscczzzjzwzjjsccdmdppdrdccmttjpttqvqdqtdqtqhqchhhtbbddmhhwdhdwdjdccnhcnndpdldvldlvddbjdbjbppjbpbssqnqnmmmclcggrmmdnnwmwddvjvdvrvzzglzlnnllhqqrbbcvvdtttdvvnfnqqstszsjsrscspszppfjjfttgqttdpdbbbvnndbdcdqdrdhhdhhdjjjzzhqqrcrvccrvrtvtnvnpppccpdpccjgjmjzzbsbgsbstsbbtdttrqtrrsrdrdcdjcddbcbjcbjbwbbslbbbbnmmtsmmrwrnwwqtqzqpprhrzhrhhldddrpdrpdpwdpwdpwwlmmzssbwswppldlmddphhnfhhczhhqrrdgdjjdttztftzffdvddqnqvvlbbncnffssbnbfnnzbnznhzhdzzrqzzptzppsnsnzntzzfwfzzvrzrbzrbzrbzrrqqltqlqppbwppmvpmvpmmbnnbhbmbdmbbhmmngmgmhgmghhvttzzfvfggrrchrrbffzjzlzsllbqqhqrrmqrrlzzsqzqqmhhmnmtntstnsnhsnnwwpdphhgjhjccbcqcjcbjbttmssqffjzjmzmqqrbbfnffcbfcfzfrzztftntbntttlddvwdvdcdhcdhdbbjfjzjwpbcvlqvcwjrcjssdfmgwrhrjvhpgqsbtzqqdwjrqsjplqjdzdcrtvqlcrfpcgwpjnbpcmbwnwbzhcvjvzzpvqnzdqdgpfrvdpfdmpprmzmghdfjjzfqjqcbplwntzmsrpqclgrqzhlsgwffqqntswnjsmrcpjlsvdrmcwdgqzsbsbvhbszqgwqffcgbqmjrfjdvbpwbrzwbjgvvjchwfscrhrtzbghjlcnsqqhdgqtdcqrrpsbzqvjwptblszrtffhwcvbngnsdjgpscfzwrncwlpfqgwdzffsqmjcbrlffftpvhjchmgmgqvjnpfsjnfzddqjsfqcpjgfrfgrtlmtfqphjfmdcvmghrdqvbbbhlstgpcgmqnwpdjwbrdbntbpncnztmnmzmsjzrwjmccqslngrvbjcjjgcvnvhsslfhwpwtjjcwgzqpdvqrlbttnnwdphztmwcdlvlqggrdprmzdfpbfhmsgqznzjhdqpmhfphqcvbfqmhnfpcvstrhdbtmljnnhqtfnpdwnszfrflsbbqjsvbvggzfhlcljwlrlfnlwlzzllzbqftlwzqsvwlldslnfnnbhlwmhqhrjlqzpdsjlhjncpwtnpnqvjtzzjnmdntmbjbcwphplbcwdfcqbhhnjnjsfplgwbrqpqmghnzvdprtlmgvwhdgpdwfvdtqtnqdvbntmsrhftwvrgwcbvhnwmhfggdzfgbdfqsbngmvjgssclqlhqggwndzzhcrzrmnzggnvbbbpzfdjtnlvlnprjtlljhtdqjlddmjdswjrwhwdbbbrmpwsgpfgnplbtzfzlvgnfrvvnbjtsglbzmtmcjbbjclmjgtdrrbpbbqzqnvrgqssfrwhrtpsbgsvnnfbmqgbvhshmpqtqljlpwptqzprdbgnzmlgtrvgnmmfhtccsvbmsfnlnzwhrmcnwmmhgwclghgmspwjvbgqrbbhhrglstdntwnvcgdcmwgbwrwhsqzsdnqsvmcbzrvtztspshrfmqbtrdtnsqdllqzdcbmvbdswzrrzchqgpgmhvjgwgnpqfwcmchsnqssnnslzwtwvbqjfbhlbdjzjrqjvsshcvcbwhsvvwtmjwjfgszmvfzclbqjhnczqcznprwzjnlgmdgbfjnrqfgvstcldnttbjmhsqgqlmzqtsqngvmdvrwcjtfljzdmnndnrbqnlqtmsqngflwsghzzsfcdnttpblqqhmtgnqmcdfmclsvgnsfpnnfssqzjtdsjbjnnmqhfctlddtwrqlpczlzvhddrtjfwgqhfcvchzqgfhdbfpbvtqcjvchqmwhvwjrbtcjgbfqjdsbfpgjrzvlgqwphshnqrvqsppgsnfswvrzpwmdfmmwntnsddzppffjvbnshhqgwclvtpjzvlbdzblhhmhrmjrpmltglsdffnstsdqwjhnjccqhbdrgnwmpwczflfvsbznpphgpbfzffbcdnbrqbwddlhvgqsdmdhmlzbdztrrswsbvdgptvhhcdtwzqqhzqpswwvftppwvwhrspfqwppjbdlhcchlftjhrpwhtvqhmwwtcbfhgbqzvzdlwlzwcsqgvmmsnhrfmwwpcrjlsgzmgdqstlwbzrzbqfnpqffmjqbqqzcnsqrfstnwjflwlpfgcjwjdvtjslrcpgwsvrbvjtzqvnjlqrvvwjhzbzqqjhcrbdtwqjbtmwfrmcgnbdcrhrvlcgrgtglpfmvpgwbzccddlrbsjzwbgwthhdmjjtpchtsbnnpgqfcpmsrgvqwhcdqzmtzlzbfdgmvtqzzdcrnhtlcwnmhdjtwdsrfnlmwpnfwdrptclvwrnwrnntwwqvfmjgswbtqcvmbfbgstvsntndzhjjnjfblqdqrgchchtgdwtvlqzrlpsqgbltjzjngdscdczwzhnlszpdnvnbrmfmjpdzvjfgvtwtpwdjjfgspbvtdjrwzncdpbsthgcwvvdbbvpvqdqpzjmlzhtjmjwmzsmrcstrsvbccqhppwrtmslggqbgglgrgffrbwzmbghfqclwwgssgghqjgfjgvwjhhwnntnrnhmfslqpmwzlggsbmrjjgfzfpjlvmshfsdjtshdlfzvjtlqwjbbgmnjhrhtpbgvcsjvwzlqvfchhpfwsbhcztmdgfzgsmszwfbvvgmgpqsrbzvtpmpqdvhgrjmmspnswjrjnjqfgjwsfbzhwhtlfwjfdhgsvcwqlbznqlnhsmzwltfwclcwgjdbhqvjbbchmcpptmpdqzwpfwrbmchpbqndtmdrwtcvlmrrnvhnpzwqcwwgmcblzvnzbzsspwchtqvjmphqtzgwdzqlbvgdjbssdjwljhlsjwzrdvqtrzcdwszqgfdwgnqdrmssqqhtblqzdhtqtqmlbbfhzvlbrphcjhzpvvshjffnsjcbgvngnsjmfdbgfzphjc";
    }
}
