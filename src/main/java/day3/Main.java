package day3;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("PART 1");
        day2_1();

        System.out.println();

        System.out.println("PART 2");
        day2_2();
    }

    private static void day2_1() {
        String input = getInput();
        String[] rucksacks = input.split("\n");

        int total = Stream.of(rucksacks)
                    .map(Main::getCommonItem)
                    .map(Main::calculatePriority)
                    .reduce(Integer::sum).orElse(0);

        System.out.println(total);
    }

    private static void day2_2() {
        String input = getInput();
        String[] rucksacks = input.split("\n");

        int total = 0;
        for (int i = 0; i < rucksacks.length; i+=3) {
            String rucksack1 = rucksacks[i];
            String rucksack2 = rucksacks[i+1];
            String rucksack3 = rucksacks[i+2];

            char commonItem = calculateCommonItem(rucksack1, rucksack2, rucksack3);
            total += calculatePriority(commonItem);
        }

        System.out.println(total);
    }

    private static char calculateCommonItem(String rucksack1, String rucksack2, String rucksack3) {
        for (int i = 0; i < rucksack1.length(); i++) {
            char c = rucksack1.charAt(i);
            if (rucksack2.indexOf(c) > -1 && rucksack3.indexOf(c) > -1) {
                return c;
            }
        }
        throw new RuntimeException("No common character between the trio!");
    }

    private static char getCommonItem(String s) {
        int itemCountHalf = s.length() / 2;
        String firstCompartmentItems = s.substring(0, itemCountHalf);
        for (int i = itemCountHalf; i < s.length(); i++) {
            if (firstCompartmentItems.indexOf(s.charAt(i)) > -1) {
                return s.charAt(i);
            }
        }
        throw new RuntimeException("No duplicate item found!");
    }

    private static int calculatePriority(char c) {
        if (Character.isUpperCase(c)) {
            return c - 38;
        }
        return c - 96;
    }

    private static String getInputExample() {
        return "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw";
    }

    private static String getInput() {
        return "rNZNWvMZZmDDmwqNdZrWTqhJMhhgzggBhzBJBchQzzJJ\n" +
                "pHlSVbVbFHgHBzzhQHqg\n" +
                "nVsqGpbbtDtTNmrmfZ\n" +
                "zrBMnbzBchshsttfbMRBgmJggmmCHGgDhDgNDGHL\n" +
                "VddZqQqdvSQMJHJGdCDCDDmH\n" +
                "pZWWllPQlPZQvZvwpSVlqlvtfswMRzBbntzRbzbfstsRzF\n" +
                "NnjjRlnWNSWWbGwccbcchfPfTvfjfTBBpvmdMjTfvB\n" +
                "FVzJtDDJDqTMlmlM\n" +
                "gVQZlFLlzHhLGShGww\n" +
                "rPZtvtFrFPgWjQvCBlcqMzlqQC\n" +
                "QGVDJJnLnVTCJBczqqTM\n" +
                "fNSSnmLDSVLhhhSNSLhGSGfVPjrFHwmQwtwWFRWRjWPHrwgt\n" +
                "SvmlrVrCvmNhSSVZVCrsgqPfbwGFwwwsflbbGb\n" +
                "QHffdnHDDQdMGbgqPwztdPds\n" +
                "DjBjWHfQDfTQWTBfpMBQLVmmmcCCcVhCBBBhhCmC\n" +
                "trLHFFQHTLHJQrflfCnLLHrRfRRPqSRPbPbbsRGqqGqhjj\n" +
                "mcMpNWVVNmNVsSbSJPcGhPRR\n" +
                "NpzNgwzZDVNZVWNpHJQLQHtQrZQHrBCl\n" +
                "JVCMfgJVrJtMBhhrfVVfhVsjvpFGFgjSSgFdSGGqjvjvqF\n" +
                "mHllHlHpmWlDSFqbdSTS\n" +
                "nmZRLzQnWVpctMVpQs\n" +
                "BrvRzWBPWbRwGRjbbRGrtrfqjCJCjCJgJsZJscFCZcJC\n" +
                "MnnnVMVhTMQhsccVfwqFJgqf\n" +
                "mMShHHppQmHrrBzwtSbWwR\n" +
                "pWWGJMJJwlnZSqjWmvSWZC\n" +
                "gtHrLttDtgFjjqRZZCrjpp\n" +
                "bFtbTpHFHLbfLFbHVttccttddJGQdJzTwdTzJlMnMBwwJJ\n" +
                "JhqHFhVMzJPQcdcVncdc\n" +
                "NhgfwSjwCWwltSfnrnRWZdpcPrrRnp\n" +
                "NNhlltBjssNBgwLFFvDmDqLzHqBB\n" +
                "LnFrnddfrLnMFjWzpFhcWpjpFc\n" +
                "ntCwgtNggCqCgCqqPPltvcjjhvmWhmvDzTzDzD\n" +
                "lqlVQgVCSPVllVQSNGMHHrdQsHrJJBnMHHJf\n" +
                "ZGZcRZNWpcHZhJfbbNblrfrgllNr\n" +
                "stBMtzCCsHMfFQjfSSPgtt\n" +
                "qmszdsCzMncdGwdWZGvH\n" +
                "PccqPqbhvSvvvtWNjTtWsWcscp\n" +
                "gRwdDzHJQgHzfdRhgHRffzwsTTjTTCjNjssCpmWWDjtCLW\n" +
                "zdRMwdRHhGJwgHlnGGSFvvSrnSrr\n" +
                "rRpMJtPwrcCTNNQNMZQm\n" +
                "mDWdWVddbbbmBflFhvTHjjQjfZTgZgLLfH\n" +
                "bhBbFFnDVhdddFBhdmpJRrzStJmwnPzcsJ\n" +
                "RjlpRRWzzRGRmGzlCRRlQjCgtvTJTtJrTPttrWTwhFvvVJFT\n" +
                "bSBdLLqbcqcLndLHZNqcZdBDPrVTDDTJSFrJJvVthTwwDS\n" +
                "cqVsnBfHffVdqnZccGMmCsGzQmjsjlljgz\n" +
                "wMzJhLtwbnMWtHcFCCFqFNNbgq\n" +
                "fMlMfjrRRmdmGCGVVCHcVqcVTC\n" +
                "MmRRRlvmQWzpvnZpwJ\n" +
                "gRmgMRMmRwzzmwHbwcTNqPDVBbPTZVqPNZ\n" +
                "fWHphpGFpfJrrhPsNTNZVsNVhT\n" +
                "WGfJdvltJJfHrJpRgvMRMSwRznwMmw\n" +
                "htJFGsGspCppCFCGthCdpmJmgmWZfqqzWzlWcfgZHgzHlg\n" +
                "nwVMjVcVcWlbnBlfWB\n" +
                "wcNDTvPPDMFJLLppDGDD\n" +
                "hjCBgPbvMvmQDzlWnWjm\n" +
                "HrHtgZRRRNwczDWwwDzsQQWW\n" +
                "LpTqNtFtLFqHLHRrqgFHffVVBChvhhVPBCPhbPbp\n" +
                "CwpbCwjGqSjVllpGCllBfhZZRDPNcPPNvLLLDSDN\n" +
                "WshFFWsgTHsdMzQvPczLfLZDZRcLfR\n" +
                "rWsJQTMhWWHdsQTgsFJgllClVpqVbqnGblCppCVr\n" +
                "gRBSGcBDBSJSvPQwrTFLjggQTQ\n" +
                "HMMnHHHZfFVFrrMT\n" +
                "HhlhppCNcJzCTtBT\n" +
                "CCffCCmRLTsQRPHQQMPF\n" +
                "dWdbgcDSNclbbdwdSqHsvHPQPTPJplPMFMGJ\n" +
                "DWbDNcqZDSWSccNTVBCzVVfmBVZnVz\n" +
                "BnsrrvZwBsBSJrrrqSTgJQjCbCjgbCHDJgJFjQ\n" +
                "hLmGlnLmGWcjGDgfFFjQdF\n" +
                "hhWPmhPtczWpNRmppzRhLchMsnwZvTMZvVSwwrsNwSsBvr\n" +
                "tDCCltNVttJhNGlMPSWdqBqSjM\n" +
                "RFQcpcRTpFcnFzdLmLSWjMSSBLSQ\n" +
                "jwzzczpFbwnHcDCsthDJJsNbst\n" +
                "dLRWTHSwTmTwTcTWvQNVVQCvVvNFps\n" +
                "GnBPtBMJBPrjGGJMjrlqChNpNlsnhVFhQsVQ\n" +
                "JtMtGJfrJgDJjPjRTZLdFcRZRmwSDH\n" +
                "VSccPJSBLgZPDLDQ\n" +
                "zfpLMmLsHQGqgQHnDD\n" +
                "zdLLMssmrdfhddcVdJtScB\n" +
                "VvpTVQHSqSHSHqqHJVmRJVHpgDBwDgjcDDDgZjBZBjwBZbRw\n" +
                "PCdssGlstdWslFPfNPrtClGjwBgBJgJNwcjBjBgZwwMBJD\n" +
                "tlJldhdhdsdhTqSTqVQqQq\n" +
                "VGqTcTqbpPwrjfbl\n" +
                "BvntnZNNsLZvLszSnCsvJthlfjTrZwlrjrpPlwlhfwrl\n" +
                "QBtNtJLvTsFdQcqWmQRR\n" +
                "fjcjhmjBvcvcSvcZ\n" +
                "HMwZtRQQpGGRgzMvLnWWnbLlSntlbv\n" +
                "JQPzzJHqQRqGMMQwHwzDZZhmmPfjDjmjsCZhPj\n" +
                "cBlZZMfBrCBMwBMCvQzTwFbQzPnbwjTbTg\n" +
                "WtzpVDzmtthzGFQTbTThnnTQQg\n" +
                "sGWstpHdpGDmdHdmGmmmJNstRMrCcBSfBSzNBNRrSRNMcMMv\n" +
                "mMPDVBZZLSmRdcFpjr\n" +
                "fggGGfbfgQStjjsdbtdt\n" +
                "gNqQgCQlNCCJgJHvnvnHMjPHjv\n" +
                "bLsRQrQsGQbLrbRZMGgbJJBJFtlFFngJphhcfBBq\n" +
                "jjdHCCjfVNmmmNDFcBcpBthcplFDFq\n" +
                "jmvvmWVjjHTCVvNjSbQGLrRzwMWsMRwfGG\n" +
                "sJNCsCFFCNPhCzlrSvRrvwhRjj\n" +
                "MMGMTwpMHGzrGczzlG\n" +
                "qVmwgHtDtmCdWCsNFmNJ\n" +
                "fmhWhjVjNpqRRJjwRw\n" +
                "gnGQGDDCgSsCvPlvPgnPgnPtwqbpHRHqHdJpzpQJJJRJRF\n" +
                "wgPGsDGPsZgGgBmBWNZNfLWWrZ\n" +
                "WdsCVtjWWWHRRqLLHncC\n" +
                "fbSpMSPSZHRRcqlpRc\n" +
                "cGMmJmfMPPPccZMNQPWvjTtdTjvgmdtTsggw\n" +
                "tPBQhHWBtQHgWQCtLwddcGnfpGpwwnbhVb\n" +
                "vqQzTNJJJTvRrTNFJsZrrzFlbbfcnVbbcwmGGGpVzmddcdfd\n" +
                "NSSqJvFFFFFQjQCjQDSDPD\n" +
                "rQZnVVrZmZmgSWqHrSzHPC\n" +
                "LGFLwcMBcllBjFNwGjltggSqSWCCzvNgSqSHtt\n" +
                "wdhqqGBwwqGMcDhcwdFFbbJppZbssbfZQsQsdVQm\n" +
                "lqBZlsjVTbVqmFrSnTFSvwncPP\n" +
                "zQztHfZQtWLJzPFnnQScFcFrvS\n" +
                "ftHJWHhfttHWffhtgLNfZDWbdqBqjbVssBDCqCdCsmClGG\n" +
                "MlbWFTJQFbFFzRdNjNtjdtBT\n" +
                "srwnrsLVHzQPQsjjSQ\n" +
                "gLpnwgnwnHCvcHHcvwgCvGFFhWGmFmqMMbQFQFFhlGmJ\n" +
                "qqNcJgJccdqhsqgsggdgqgcrtfNWNZzVbvVFzttMfzbVMZ\n" +
                "GLlpPpCpwPLDGvrFVWrWWbZt\n" +
                "DlRCDDLSjTjDjSRSjPClwnwSHHHQmmQvTJcQgvddHsqdcgmB\n" +
                "jmRjRbRQLLZbPnbrcTTHHHNn\n" +
                "MfhhmmwtvStrpnJJHc\n" +
                "fgqlvfhvFzMwqfvMfFWlmMvLZsdQsZVdCdLZdGQjRzdQjD\n" +
                "lTPcDlVdTlVVMSDfTJccVzdlmMgGBmppgBmnHGHqHqQqqQMH\n" +
                "ZRjWFPsLNLLrPhWNtnBBvnpGpHGpQmHnmR\n" +
                "CtwssCNLrsZWjrjcbfPzwJJJffDbTl\n" +
                "cjMvvqpJFqhShNCRQR\n" +
                "ldtDgQZDPdzztLZgPTtfbnStfBSbNNSbnbhhSS\n" +
                "TDsrzsZZZTFHmVHjcsQW\n" +
                "BQmQchrmBddcmZZdpSgrpswWWswVsnnnDJVnnZFnGN\n" +
                "TfStMPLTHvbvRVGnHGsNnJWFNV\n" +
                "qtvMRMMPbbPMLqRPvRTRzMjSSmprpQdBchlmmgldgjzm\n" +
                "nRRnvNPhrbZDLjvS\n" +
                "HCszMwcHHcLDrbQDWr\n" +
                "ptszqwdMbnnhPBqN\n" +
                "QbzhhfbFhBbpbzwwLjLJjSjltL\n" +
                "mNndGrSStHJTJLln\n" +
                "rDMMNVWdVpCbSbSp\n" +
                "tDTSTSTTTTJDwqjWqBWttdjg\n" +
                "nNPmVfnGfPNVLmNzfnzPVFMjdpBwWZwZHwBLBqgjqpWH\n" +
                "dfGPfVQGVPhGzlmnzSvsSTDJhTbTTrrSRD\n" +
                "ZfgtZBptBfRQNQggjjrjjwmwsQJPzrwm\n" +
                "TwTGGwTwzzsJzTsH\n" +
                "lFvwqFLhFMnqcLlVLMLfptNWppppDBDbDfbFgW\n" +
                "mjftBfVPjttmjcSjcPttzJlvnrwvTRrTnvwvlRrHHTHRTR\n" +
                "WZDWDNLFWbZbcMDWGZDbNdMCRsnTdTvdnqrHCTrvsRRvwC\n" +
                "DQFZLNNgtBJQcBzJ\n" +
                "HbZQZFVbQVpQplQZGbGchDffltfLtmdgDjggTmtm\n" +
                "zWzRCdnCRBRdJrzDjLhDthjLJTTtjq\n" +
                "CPPnwSrRdRSzCGMcZZZMwFwMZF\n" +
                "WBQqNQnQllwnWQlvBBMlljHTqqFdGfmTdFfcFTFFcqmP\n" +
                "rsRRVrZhrzbtpZRRhFDmPvfFFrfTdFHGvc\n" +
                "VtSCtSLbtsZVtttthCbJSWSlJlwJQggWWglvwW\n" +
                "QfFLWCvRfSLFCtvtFhNcqDDcGVbhGcqh\n" +
                "ZVgrdZZPPZZzPwdjzZhmccsqJGqDdsDDNddD\n" +
                "pzzwpgZzZZTznZnjZZzPVRLQLlvfSlQRSpWlCvtSQv\n" +
                "RtcHhRMcrHhBrrTNDVBNLqLqQqfBPm\n" +
                "wCbWzWbvdWCjbWppmtmNmqmLLsfsNV\n" +
                "lwjWdbztgHTgggnnnR\n" +
                "flBbzbMfbrTlrMvBCcwPggdmcdmg\n" +
                "VDVVRFZRZSFFhQLSGFQhjSVZCgpvPwLCzpdWWzccwdvvvwcC\n" +
                "hDHRGQVHHQVRZSQGbqqfNTlbHzrbbsqb\n" +
                "MTFdTsZpPTcMpFCPdCBmMBmRfRGBmQgQRRgt\n" +
                "vbDSwvhzznnbbhDWnvSzRBgQQLgLQltqtqlmwfGB\n" +
                "jVjhfSnNDNbzzWzjWSjrCFNpcHdpTTJddJFpsJcc\n" +
                "ZrrZPHfChPdDPVVdDq\n" +
                "vFmsbTsmSbbBJssmSBvTmmnTrnrwlWqwVlLrVTLLTWqL\n" +
                "JrFbpsvFBMBmzBzFStcRhjZjfCCpZNCtct\n" +
                "TGgRrTggwwtvtQtdCdQNqN\n" +
                "sJHZJVZHDBpFBZBBNzNdhzdpSzddvqhN\n" +
                "VZcvFsJVFvsmvssbcnrwbrnGMbMlRn\n" +
                "SdcdWzMJdSMWMddZJdVcmBmwrwqrrnVnVNtr\n" +
                "mlQHCfgbjsfQTbfCBNtVhVnntVBnVh\n" +
                "HLDslDDmblgHfvLHPJFSZPpDFpFFpdPS\n" +
                "qNqPNJvcSzGGPQnGQp\n" +
                "bWhbgsshZWBhltthhbWtCsZNjrzpnQnnznnjtQFrjGjVFGnn\n" +
                "bRDNddhNdDsZdNChmvDmmwqqvLqwSJDq\n" +
                "TnSfPnCSmnSgpSTmfLzfMFLWFJJLWWsBsr\n" +
                "jdQjcdqDVVwDcPsPzMRJMLqPqR\n" +
                "PGhGchjhtZlTGTHCCb\n" +
                "ZZRrJJqSqJwNFFphsGsLPJ\n" +
                "blcMCflvTTPFFNpVvsFv\n" +
                "CcTlltTmtmMdmCmnlllBDDSDQSwSjRDQSdswjR\n" +
                "MCCPNsnQFWbvvTPF\n" +
                "CcCVJJhjVJZRtcCclDDlbcbTcGFFDz\n" +
                "HpjtVwVZfpjJVhZgCVtLmrBwdMrLsNNsMmdLqB\n" +
                "TJTDTnrFzzdWgWGJSSMJwg\n" +
                "LhPVttjtLmsPqqqVsVpsjLlgWlwHvGnlHWlgHlGgwvlP\n" +
                "mQshLhmsnsqZcqhZqpshsLVpNTNbBfzTRBQdFRzNNFBTdbzR\n" +
                "ZGqMLGqvJsJsMJmd\n" +
                "PDVQPfPcrrcFrrzrTdgCjSSCzgszmlJjBj\n" +
                "PfRtVfttVcWtVJrfbGqvwqLpRRwvpppH\n" +
                "HmLmMSnnWnrTrnvpqFCHVGfzVFVHQj\n" +
                "ttsstRhhcNwbswNtdwsdNPFfjzQppQPjfGGfQVPCpR\n" +
                "bbsDNtDcbhstsSZLDmSSgCmnSS\n" +
                "tfwBBLcJVrDnqvLv\n" +
                "zmWWJRZhWRRRGRNdgSZGgWTvpnjvrDqvpHjjzrpnrPDnHj\n" +
                "NdJmSGZWRhRNsghWTJmdGfQCtllCcFMwffBftsfMQc\n" +
                "lTLgTghpGZJDBrnGWnnm\n" +
                "VlRwlHttwqmHHbDWHJ\n" +
                "twldzCvsRdsFFtRtSczTjSgMcfSpSzTM\n" +
                "pBpMBTcSlNtMcTfFCmbPDzCDLb\n" +
                "JgrjjJqhGZQrQrZhnJGDDCZfvPDdDzFFdzfmZL\n" +
                "QHhqqnrVJJPhHrnGQgwMNwMMctcWRWSBMNtNsW\n" +
                "FJrlhpcfDCcFWpNpwWwjNQwz\n" +
                "RTTvPdbjWzMbnNNM\n" +
                "GRZTGggGgtvjGcqrBcttcDlFhr\n" +
                "pMRVdVbbMMMSdWWqHpCTvTjnBBBFFGGB\n" +
                "smNfZgcsNrcmzggZszsgRnPGFHjBPTBTjGjPTBNj\n" +
                "RmwgsmgfrzzsZtfgZLQQSVWlwbdMhlwdqQ\n" +
                "mRRjPmLrrSmzSczSzPgVZFpTCpZCMWrZQMQrZJZT\n" +
                "BvdbHNdnJtvBDbqqdBlvwvqpDQMpZQFMCsQCspZTMMCZCF\n" +
                "nBlfbfbndJBHPfLRfmhhhhPL\n" +
                "ScJDFBNLLbVRqVfZ\n" +
                "rWrgmdMgnnBhBtnntf\n" +
                "CwBWWMgCwddCgwsQjsrvNvlTJzSNHwNTHFJHzS\n" +
                "vnddCrNpCgtjLdSdgCgCCvLnWqDhWBQhHqQHDqBhQHDHNNDl\n" +
                "wPTVfVTJmZGJVJGffZBwHMWlWlHlWtbQDqbl\n" +
                "mGsJVVJsTVTTmtJVzzTJjdSjjprzCvpSLSCjdnLg\n" +
                "zLNggsVHmNNsssLmwzLQZLwDRvGQBqGGDDBBvvDBDqPhRG\n" +
                "WrCjbtJdbFhBRglGgjqv\n" +
                "JWCJcWcSdWcctnJCcJJJbcbmzwwznmgLzNzmLHmHZMwsZL\n" +
                "JRRDNNhhszMTzNMwCG\n" +
                "MnHPqmgmHjPnnvjqdmjFLQwLwTLwzTwTdGLCzS\n" +
                "BnPPZqmcfqgqnnZmBmqjqhfWVJlRMlhWlRDlVsssbh\n" +
                "nmTLTqsvqnwqsvwDPnLHdNVrMMHHCBlmVdmGNV\n" +
                "RgRpcJhQRfQZcJbWhQpBHCjVCdjCVGdddMllHp\n" +
                "fczbZhzbtcZfgRRBcWSPPwFsLSDswSwTsSzw\n" +
                "rbFpzFCVBrrBZCjbCzHHBVdJllGDLsLrDtsswswstGJs\n" +
                "QNhNNnNnnQhNWSnRhnJtdpJpJtMDGsGLLtsQ\n" +
                "ScmRvNRNnWWvNvNvfpTccjVZbqgZgVzqHjCjTVTVVq\n" +
                "BTppwCwBpwwBqnjlHcLBTHnbbSbDthsSSJgsnDDRgJRD\n" +
                "FVGzzvrdMGSSsdtZtZgd\n" +
                "QvQtvtGFlBLLjLQL\n" +
                "gsWWsNMjwgPMPWnMjShHHZSZbmZbbmTSnb\n" +
                "rlCvVQrCfqffpVjQRqCCvDDTTTmmZhZTmZhThFmhhZZhqb\n" +
                "CDDVJpVfrJJVJLMNzMwWwLwj\n" +
                "nHrcsZrssPcBPtQJLJtQQCZQpV\n" +
                "GFWzNzNFdNbTMMqbGTqTqzqqdLCpfDQCtRVVCLtdCfQsdCCt\n" +
                "TlNqGTWFNmMMszhGsmFTWGFzwHnvSjgPgvgSjllBvBnvwPBB\n" +
                "mpMggjgMlmtjtGMwZpcSscBlcsSblhsfSdfs\n" +
                "zzPVDRrLrCTQNCzNRTVFNLhBhBSqdQbcfSsJBJdbjJfB\n" +
                "RPTRPTVNTFzVrHVDCrTHmHtwMvwWMmtwmGjWgvGv\n" +
                "rLMcvfHVfMgLFvfNnBBzwRbBwnrGNs\n" +
                "dttJjJCtdjmwzwBCRRCqcs\n" +
                "TddDQDJDtQJtcJFpPQHPQMvfQlFL\n" +
                "LQSqqpqTCSJcsDcqQMMhnnjMjppZhwHZbZ\n" +
                "NRtvtmgmvdBffgtVCBWVRgFbPzHbMHbnwwjMPZfHbPjzPP\n" +
                "RNtvCvNdgtNNmldgvCFRNVLsQLqJcQGJJrccGSlDLDLr\n" +
                "GdwwqqqwGVtjdPvTCplbHTPbPzPTpp\n" +
                "RpLmLLpFfNsgTzclhzClThgH\n" +
                "ZFsWZLFZJsNsnWsnRsRfnfJQGBttjdGJjBvvwjdpjjttvj\n" +
                "tfPzzLrrdrQlTlvn\n" +
                "qJRBhNhNGVRBFRTlnJvCmvmJPCCl\n" +
                "VVPDNchNMVFGRMFcRVBjsZZcttSLSZzzStcWtZ\n" +
                "pTrwTrnjtttjprTSTNTQfcjcgPsPZfPgjdgdsQ\n" +
                "mCmCzvzhmJDHzJDbhFCDPsgddcsfcdsbdgVRpdVs\n" +
                "zqJzFCDhmqvGhMmCvmGhMCGJnSlnllSBLllLMtNpWtpNBnlt\n" +
                "JBhJrFLhGrnJZrlcbffndnggfggf\n" +
                "jqmWMGGSsqCsmpjmsDQzlcHgbtdzjjlVfctjHV\n" +
                "GWSmSCspCsMSpRmSmqMMCBvFLJLhTTwFhRFLLBTwrv\n" +
                "BCdWccqcqpQqrsNgGsWMgfNW\n" +
                "lFttLzzLwnfsLrsNsNLG\n" +
                "zjNlznlwvRPZnltwvPFnZRCbmjCcqjpcpQcqVVdbdVBm\n" +
                "CwTbbCGNFHtHwwjSjJpzjLMdMMzT\n" +
                "rscqqVvWgWrZMjrlmSzzmLrM\n" +
                "WPqqZnPqgncnBQQVRbCDwRHGSFHPwRNw\n" +
                "ZQnZwWjFvdsHwBJltfmfSlsqlJ\n" +
                "gPprhMDTpMpPMVNqNRqNlJhltJdJ\n" +
                "pLGCcCrgppCrVcMpdzjvzvjLwQQzFjwzHF\n" +
                "NmmmvfqcvmLSQhCLvtvL\n" +
                "TVlWTZVJZJsFbwWbQQhtQgLFCnSgghLt\n" +
                "hZJTJZhwZlRJrJWHVlblMBffmqfdNMjdGdBBqqcH\n" +
                "GJJfLfptGqqqnsVqVVjjDnNc\n" +
                "mZPSvPmBCdmwdCLDshSbRnnDDhRL\n" +
                "gvBrBvPBPPZCTLZmwmrgQdwfTJMHGzHfWffJzFzttHWFzW\n" +
                "sBMvmzWzmFmNWJfffZNLfbqZbtZq\n" +
                "jRQVRnhhppnVhjgnDLttLqbLqLQfDLss\n" +
                "jRRgpGVGhwhnspgpRppwSnBvMMcWvGczGJJHdmHJmJFF\n" +
                "VCLHFwHMhLghHHWhFFgWNMMVzmdmbvWdJqBPJPPBppqmBdzm\n" +
                "SRTsjGZTsZZnSnGZGqdBmrqPvmqqqsPpmv\n" +
                "GvQSGtZSQllVhtLMcLLNMH\n" +
                "GsNdWpdVWGSHjFCWCqFFgqngvW\n" +
                "mRQTcrLRmZTPRLPZfqqqHbDDDgFvFnvqzQ\n" +
                "hfZHrwwmcZRwlLfwlmrRjMJJsVjslVNBGNjpVBBG\n" +
                "pllpztRqBBvvGPpG\n" +
                "QQhhZQbVcZQTPMWWGbvvbMHM\n" +
                "cwgCQCLZChQwwLZVzCrzzqNCzrDqdFPF\n" +
                "bgcLPvvpcbdsbpSsHRTCqsRfWfsHRm\n" +
                "lZlQtthrnlVMmTHqqqqHSChB\n" +
                "rDtlzttnlSNrMtQjZVrcgGDLLddcdcpPgPGJJd\n" +
                "jvGbvLLQDSGlRmmSLjlDmRQggFBrMCwWdsBFWBFjdrrWrr\n" +
                "PpTfcPZpNTVNpHzTzzzpPJhBcwrrhFsrMdFcMCBFhgMF\n" +
                "JTTqdtfzfzJpqffNdTTHGtQRnmDQGGLQQlQRbblD\n" +
                "CQQCshCMwgQhMdjWJFBPpbjgmmWj\n" +
                "SNNvcGNSZSTDtGDcczJJBmzbjBJjmppbppms\n" +
                "cDtfDVNTGGGNNrwLLwHdqLhfLs\n" +
                "ngghZCChzhNjjNbbJfdh\n" +
                "slPPRLlBBlVRMvRllLLHvcpcdFfJjvdFpfHfcZ\n" +
                "RDZPZBLmPVWDVrQtnzSTmgTwmTSg";
    }
}
