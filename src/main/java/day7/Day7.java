package day7;

import java.util.List;

public class Day7 {

    private static final int DIR_NAME_INDEX = 5;

    public static void main(String[] args) {
        System.out.println("PART 1");
        day7_1();

        System.out.println();

        System.out.println("PART 2");
        day7_2();
    }

    private static void day7_1() {
        String input = getInput();
        String[] lines = input.split("\n");

        int i = 0;
        File dir = new File("root", null);
        dir.addChild(new File("/", dir));
        while (i < lines.length) {
            String line = lines[i];

            if (line.equals("$ ls")) {
                String dirName = lines[i-1].substring(DIR_NAME_INDEX);

                dir = dir.getChild(dirName);
            }

            if (line.equals("$ cd ..")) {
                dir = dir.getParent();
            }

            if (!line.startsWith("$")) {
                String[] file = line.split(" ");
                String name = file[1];
                File newDocument;
                if (file[0].startsWith("dir")) { // it is a document
                    newDocument = new File(name, dir);
                } else {
                    newDocument = new File(name, dir, Integer.parseInt(file[0]));
                }
                dir.addChild(newDocument);
            }

            i++;
        }

        while (dir.getParent() != null) {
            dir = dir.getParent();
        }

        List<File> allDirs = dir.getDirs();
        int total = allDirs.stream()
                .map(File::getSize)
                .filter(size -> size < 100000)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.println(total);
    }

    private static void day7_2() {

    }

    private static String getInputExample() {
        return  "$ cd /\n" +
                "$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "$ cd a\n" +
                "$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "$ cd e\n" +
                "$ ls\n" +
                "584 i\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd d\n" +
                "$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k";
    }

    private static String getInput() {
        return "$ cd /\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "171526 ghtzhjwf.nls\n" +
                "dir gsdsbld\n" +
                "dir hbmjtb\n" +
                "296801 mjfjqw.ccv\n" +
                "dir nfn\n" +
                "dir qmrsvfvw\n" +
                "102565 qqjnqb.chd\n" +
                "dir svgbqd\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "153563 ghtzhjwf.nls\n" +
                "243252 gsvjgj.jsm\n" +
                "154134 hghnrbqg.rzb\n" +
                "$ cd ..\n" +
                "$ cd gsdsbld\n" +
                "$ ls\n" +
                "dir npmncvhh\n" +
                "dir qmrsvfvw\n" +
                "dir sqtnlr\n" +
                "dir vzndpc\n" +
                "$ cd npmncvhh\n" +
                "$ ls\n" +
                "81366 dwbgr.ztr\n" +
                "144577 fzjmcq\n" +
                "dir mphhrqf\n" +
                "dir rnmvggfd\n" +
                "276454 zfl.ghv\n" +
                "$ cd mphhrqf\n" +
                "$ ls\n" +
                "dir qlcfs\n" +
                "111207 shmcrf.wlr\n" +
                "dir zwsnwvnv\n" +
                "$ cd qlcfs\n" +
                "$ ls\n" +
                "283904 fpljqj.pdw\n" +
                "83520 hsclcqqt.pff\n" +
                "dir htwl\n" +
                "dir lqjhfdch\n" +
                "5842 mdjzmbc.qtv\n" +
                "dir nqfdhlcg\n" +
                "120167 twgqhvft.cgw\n" +
                "186998 zclhcr\n" +
                "dir zfl\n" +
                "dir zlqgr\n" +
                "$ cd htwl\n" +
                "$ ls\n" +
                "268134 hmwnn.htq\n" +
                "$ cd ..\n" +
                "$ cd lqjhfdch\n" +
                "$ ls\n" +
                "21479 tpdsgf.hgd\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "dir dhjfqv\n" +
                "203675 ghtzhjwf.nls\n" +
                "39527 qfwdmzfv.ggd\n" +
                "$ cd dhjfqv\n" +
                "$ ls\n" +
                "135074 dqs.wht\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "17334 wlsd\n" +
                "$ cd ..\n" +
                "$ cd zlqgr\n" +
                "$ ls\n" +
                "dir crs\n" +
                "dir whrm\n" +
                "dir zfl\n" +
                "$ cd crs\n" +
                "$ ls\n" +
                "220281 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd whrm\n" +
                "$ ls\n" +
                "279796 pcnl\n" +
                "dir pjzpqs\n" +
                "$ cd pjzpqs\n" +
                "$ ls\n" +
                "dir smz\n" +
                "192921 sqtst.lcz\n" +
                "21397 trst\n" +
                "154861 vtgdsnmv\n" +
                "$ cd smz\n" +
                "$ ls\n" +
                "249693 mjfjqw.ccv\n" +
                "dir tdwqpg\n" +
                "$ cd tdwqpg\n" +
                "$ ls\n" +
                "157907 wjv.rth\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "dir hwlhshtr\n" +
                "$ cd hwlhshtr\n" +
                "$ ls\n" +
                "90468 srrv.jst\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zwsnwvnv\n" +
                "$ ls\n" +
                "209371 ctmcqlz.nwh\n" +
                "154262 nqngjf\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rnmvggfd\n" +
                "$ ls\n" +
                "dir czzrdvc\n" +
                "203540 dnwtwzd\n" +
                "dir fcsjqg\n" +
                "dir fwdprwpq\n" +
                "74582 qlnqwnzp.ttz\n" +
                "dir tvglfb\n" +
                "$ cd czzrdvc\n" +
                "$ ls\n" +
                "dir blplbjpw\n" +
                "$ cd blplbjpw\n" +
                "$ ls\n" +
                "2835 zfl.zvw\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd fcsjqg\n" +
                "$ ls\n" +
                "81548 ghtzhjwf.nls\n" +
                "$ cd ..\n" +
                "$ cd fwdprwpq\n" +
                "$ ls\n" +
                "11156 gsvjgj.jsm\n" +
                "75010 rgscvjq.zlw\n" +
                "122327 szft.bjb\n" +
                "dir zfl\n" +
                "268883 zpgcwvjf\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "dir sphpbjt\n" +
                "$ cd sphpbjt\n" +
                "$ ls\n" +
                "31414 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd tvglfb\n" +
                "$ ls\n" +
                "118050 gsvjgj.jsm\n" +
                "265116 sdmldsd.hhm\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "203965 szft.bjb\n" +
                "dir zcgfg\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "dir gqvmv\n" +
                "$ cd gqvmv\n" +
                "$ ls\n" +
                "175614 mjfjqw.ccv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zcgfg\n" +
                "$ ls\n" +
                "110104 ddzcbm.qtb\n" +
                "dir fpglbth\n" +
                "148639 nqfdhlcg.fsz\n" +
                "dir pfjz\n" +
                "166120 wjrmgl\n" +
                "$ cd fpglbth\n" +
                "$ ls\n" +
                "58850 qlggch.tng\n" +
                "$ cd ..\n" +
                "$ cd pfjz\n" +
                "$ ls\n" +
                "197076 wplpj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd sqtnlr\n" +
                "$ ls\n" +
                "189086 gsvjgj.jsm\n" +
                "dir ngr\n" +
                "210016 pmprhlg.rsg\n" +
                "277979 szft.bjb\n" +
                "282202 tfqcnn.hlf\n" +
                "$ cd ngr\n" +
                "$ ls\n" +
                "dir fdhd\n" +
                "dir hwsqqt\n" +
                "dir qmrsvfvw\n" +
                "$ cd fdhd\n" +
                "$ ls\n" +
                "7384 fhhp\n" +
                "dir fpljqj\n" +
                "91732 nqfdhlcg.gwf\n" +
                "69137 ptcrmc.wwr\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "282109 rtfhcbc.pqj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd hwsqqt\n" +
                "$ ls\n" +
                "174820 zvmgv.tcd\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "228739 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vzndpc\n" +
                "$ ls\n" +
                "183360 fpljqj.nbh\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd hbmjtb\n" +
                "$ ls\n" +
                "219988 hlvjdg\n" +
                "dir lndmtm\n" +
                "107247 rtpvh.srl\n" +
                "dir sgt\n" +
                "dir tgjszvsg\n" +
                "166122 zrshs.phz\n" +
                "dir ztrvv\n" +
                "$ cd lndmtm\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "dir hscwh\n" +
                "dir wjv\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "102717 qmrsvfvw\n" +
                "$ cd ..\n" +
                "$ cd hscwh\n" +
                "$ ls\n" +
                "dir qgz\n" +
                "dir qmrsvfvw\n" +
                "$ cd qgz\n" +
                "$ ls\n" +
                "281901 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "102781 fpljqj.gtv\n" +
                "197014 gsvjgj.jsm\n" +
                "174895 pvz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd wjv\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "295195 mjfjqw.ccv\n" +
                "214886 qfwdmzfv.ggd\n" +
                "dir qmrsvfvw\n" +
                "72164 vncjvfhh\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "dir fzbppql\n" +
                "dir jpqqr\n" +
                "dir lzq\n" +
                "dir pjjbmllm\n" +
                "dir qmrsvfvw\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "260943 ghtzhjwf.nls\n" +
                "$ cd ..\n" +
                "$ cd fzbppql\n" +
                "$ ls\n" +
                "29399 wjv\n" +
                "$ cd ..\n" +
                "$ cd jpqqr\n" +
                "$ ls\n" +
                "45275 zcwbrvd\n" +
                "$ cd ..\n" +
                "$ cd lzq\n" +
                "$ ls\n" +
                "180833 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd pjjbmllm\n" +
                "$ ls\n" +
                "64063 mjfjqw.ccv\n" +
                "183683 vrfd.wlw\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "226047 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir bzcfzh\n" +
                "272794 lnzpvhj\n" +
                "dir vsrgqmlt\n" +
                "dir zbthlb\n" +
                "$ cd bzcfzh\n" +
                "$ ls\n" +
                "63095 mjfjqw.ccv\n" +
                "45335 nqfdhlcg\n" +
                "162307 vqqt.vbg\n" +
                "$ cd ..\n" +
                "$ cd vsrgqmlt\n" +
                "$ ls\n" +
                "dir nqfdhlcg\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "dir wjv\n" +
                "$ cd wjv\n" +
                "$ ls\n" +
                "81528 cslzgjtp.qzg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zbthlb\n" +
                "$ ls\n" +
                "dir hjp\n" +
                "dir twfw\n" +
                "dir zfl\n" +
                "$ cd hjp\n" +
                "$ ls\n" +
                "20745 pvjwrzsl.pmg\n" +
                "$ cd ..\n" +
                "$ cd twfw\n" +
                "$ ls\n" +
                "dir csmmbjhp\n" +
                "$ cd csmmbjhp\n" +
                "$ ls\n" +
                "165998 nlsd\n" +
                "109132 vbjlnqt.lsd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "227633 jcs.vhj\n" +
                "dir tvfhvbp\n" +
                "$ cd tvfhvbp\n" +
                "$ ls\n" +
                "116169 lgv\n" +
                "175862 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd sgt\n" +
                "$ ls\n" +
                "151135 nqfdhlcg\n" +
                "226449 nqfdhlcg.sqp\n" +
                "148179 wjv.fgc\n" +
                "$ cd ..\n" +
                "$ cd tgjszvsg\n" +
                "$ ls\n" +
                "98354 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd ztrvv\n" +
                "$ ls\n" +
                "163992 blmmm.gcf\n" +
                "dir fghl\n" +
                "dir fpljqj\n" +
                "226325 nqfdhlcg\n" +
                "dir qmrsvfvw\n" +
                "284965 vhbffmcg.fwt\n" +
                "$ cd fghl\n" +
                "$ ls\n" +
                "dir lgpwpmzp\n" +
                "dir sqjqg\n" +
                "$ cd lgpwpmzp\n" +
                "$ ls\n" +
                "dir ctr\n" +
                "dir nqfdhlcg\n" +
                "279439 zfl.npd\n" +
                "$ cd ctr\n" +
                "$ ls\n" +
                "64805 jfflsd.gbc\n" +
                "163058 zbvpc.znm\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "40180 jsqtwpt.qtq\n" +
                "87408 rmpbprz.lwr\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd sqjqg\n" +
                "$ ls\n" +
                "140444 bsglv\n" +
                "214121 crzdv.dcc\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "56575 gqw.dzr\n" +
                "293957 gsvjgj.jsm\n" +
                "272507 jvd\n" +
                "dir tgfvcpp\n" +
                "178972 vndshbth.mzw\n" +
                "dir zwtz\n" +
                "$ cd tgfvcpp\n" +
                "$ ls\n" +
                "dir bhq\n" +
                "$ cd bhq\n" +
                "$ ls\n" +
                "111454 gvq\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zwtz\n" +
                "$ ls\n" +
                "39290 nqfdhlcg\n" +
                "140517 qfwdmzfv.ggd\n" +
                "dir tcnv\n" +
                "177429 zlzsq.fph\n" +
                "$ cd tcnv\n" +
                "$ ls\n" +
                "286997 fpljqj.phd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "252862 jbznh\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nfn\n" +
                "$ ls\n" +
                "dir fqw\n" +
                "dir mpz\n" +
                "dir qmrsvfvw\n" +
                "dir zfl\n" +
                "$ cd fqw\n" +
                "$ ls\n" +
                "144372 ghtzhjwf.nls\n" +
                "100013 mqwwjbvz.scd\n" +
                "95547 vspwhq.dwn\n" +
                "$ cd ..\n" +
                "$ cd mpz\n" +
                "$ ls\n" +
                "dir gntjg\n" +
                "dir jfbhz\n" +
                "7835 nqfdhlcg\n" +
                "dir vpgpz\n" +
                "dir zfl\n" +
                "$ cd gntjg\n" +
                "$ ls\n" +
                "dir hdq\n" +
                "dir hvcdpzr\n" +
                "dir lth\n" +
                "27002 mjfjqw.ccv\n" +
                "dir qmrsvfvw\n" +
                "dir scncl\n" +
                "$ cd hdq\n" +
                "$ ls\n" +
                "dir jwhnt\n" +
                "$ cd jwhnt\n" +
                "$ ls\n" +
                "153428 fswqv.jpf\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd hvcdpzr\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "135000 fpljqj.smw\n" +
                "275125 hrqwfjjz.rdj\n" +
                "dir pmcpnqrr\n" +
                "58960 qljhbczf.qfn\n" +
                "222912 szft.bjb\n" +
                "dir wvvzbt\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "282896 nqfdhlcg.bjm\n" +
                "$ cd ..\n" +
                "$ cd pmcpnqrr\n" +
                "$ ls\n" +
                "dir nwjzld\n" +
                "dir tfdcg\n" +
                "dir vwlbtgnh\n" +
                "$ cd nwjzld\n" +
                "$ ls\n" +
                "74948 wjv.psf\n" +
                "$ cd ..\n" +
                "$ cd tfdcg\n" +
                "$ ls\n" +
                "77925 gsvjgj.jsm\n" +
                "dir lcdfdmlj\n" +
                "dir pthwnf\n" +
                "227063 qfwdmzfv.ggd\n" +
                "293860 qmwr.csp\n" +
                "154426 scwd.mdc\n" +
                "$ cd lcdfdmlj\n" +
                "$ ls\n" +
                "52503 mjfjqw.ccv\n" +
                "$ cd ..\n" +
                "$ cd pthwnf\n" +
                "$ ls\n" +
                "176935 fgcwjjz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vwlbtgnh\n" +
                "$ ls\n" +
                "dir nqfdhlcg\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "dir lnwtl\n" +
                "$ cd lnwtl\n" +
                "$ ls\n" +
                "252540 cgj.pdg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd wvvzbt\n" +
                "$ ls\n" +
                "25603 bvhd\n" +
                "24426 qzwgj.bmb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd lth\n" +
                "$ ls\n" +
                "dir dmbf\n" +
                "60608 ghtzhjwf.nls\n" +
                "dir ndbcrvw\n" +
                "dir shsgqzn\n" +
                "27467 zfl.tdf\n" +
                "$ cd dmbf\n" +
                "$ ls\n" +
                "dir zpggmccr\n" +
                "$ cd zpggmccr\n" +
                "$ ls\n" +
                "238504 hqsgz.jfh\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ndbcrvw\n" +
                "$ ls\n" +
                "289441 bwbdc\n" +
                "dir zfl\n" +
                "84967 zhwz\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "95245 mjfjqw.ccv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd shsgqzn\n" +
                "$ ls\n" +
                "184543 gqrthw.gwf\n" +
                "61456 wzbbsqrp\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir bql\n" +
                "247487 szvbjdjl\n" +
                "58312 wjv\n" +
                "241150 wjv.ltm\n" +
                "$ cd bql\n" +
                "$ ls\n" +
                "93199 fpljqj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd scncl\n" +
                "$ ls\n" +
                "13092 clgmqlfl\n" +
                "dir dcldv\n" +
                "dir fsrznscl\n" +
                "21910 nqfdhlcg.lld\n" +
                "dir prcgb\n" +
                "$ cd dcldv\n" +
                "$ ls\n" +
                "271970 nqfdhlcg.dgv\n" +
                "$ cd ..\n" +
                "$ cd fsrznscl\n" +
                "$ ls\n" +
                "dir bcdrv\n" +
                "$ cd bcdrv\n" +
                "$ ls\n" +
                "96252 fpljqj.cdr\n" +
                "154325 tvf.vhv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd prcgb\n" +
                "$ ls\n" +
                "69766 lnsvgqq.psj\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jfbhz\n" +
                "$ ls\n" +
                "286498 ssbmgts\n" +
                "$ cd ..\n" +
                "$ cd vpgpz\n" +
                "$ ls\n" +
                "63751 gsvjgj.jsm\n" +
                "220526 vvlvcs.dpc\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "182996 ghtzhjwf.nls\n" +
                "dir jcffb\n" +
                "dir jzl\n" +
                "dir nzlv\n" +
                "6752 snwmlr.glp\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "dir btsdth\n" +
                "dir fwdw\n" +
                "dir nqfdhlcg\n" +
                "dir qmrsvfvw\n" +
                "203470 svsvcgj\n" +
                "$ cd btsdth\n" +
                "$ ls\n" +
                "176953 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd fwdw\n" +
                "$ ls\n" +
                "95939 crffczjt.gsq\n" +
                "dir mbgzf\n" +
                "dir rqdnjfdq\n" +
                "296397 zfl.fjb\n" +
                "$ cd mbgzf\n" +
                "$ ls\n" +
                "179220 mjfjqw.ccv\n" +
                "$ cd ..\n" +
                "$ cd rqdnjfdq\n" +
                "$ ls\n" +
                "204152 qmrsvfvw\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "194439 gwc.wdp\n" +
                "167934 qfwdmzfv.ggd\n" +
                "151571 sczw\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir dwc\n" +
                "103919 gfzgg\n" +
                "6816 shpch.chl\n" +
                "$ cd dwc\n" +
                "$ ls\n" +
                "17813 gsvjgj.jsm\n" +
                "80522 hbhlv.pqh\n" +
                "dir htpt\n" +
                "dir hwg\n" +
                "dir nslrrrfg\n" +
                "dir psgw\n" +
                "231148 sdfvzdwm.wlz\n" +
                "102460 szft.bjb\n" +
                "dir wjlfgt\n" +
                "$ cd htpt\n" +
                "$ ls\n" +
                "162107 wjv\n" +
                "$ cd ..\n" +
                "$ cd hwg\n" +
                "$ ls\n" +
                "dir gslvrbt\n" +
                "dir qmrsvfvw\n" +
                "$ cd gslvrbt\n" +
                "$ ls\n" +
                "dir fjwn\n" +
                "107757 gsvjgj.jsm\n" +
                "$ cd fjwn\n" +
                "$ ls\n" +
                "268653 qptczjlq.prv\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "10557 nqfdhlcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nslrrrfg\n" +
                "$ ls\n" +
                "112961 gsvjgj.jsm\n" +
                "dir hjgbgq\n" +
                "dir jctqdpq\n" +
                "dir qgfb\n" +
                "dir zfl\n" +
                "$ cd hjgbgq\n" +
                "$ ls\n" +
                "124947 mjfjqw.ccv\n" +
                "$ cd ..\n" +
                "$ cd jctqdpq\n" +
                "$ ls\n" +
                "203489 vgfhrl\n" +
                "$ cd ..\n" +
                "$ cd qgfb\n" +
                "$ ls\n" +
                "33980 nqfdhlcg.pqs\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "193098 gsvjgj.jsm\n" +
                "dir vmzghf\n" +
                "26070 zfnppjsz\n" +
                "$ cd vmzghf\n" +
                "$ ls\n" +
                "235035 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd psgw\n" +
                "$ ls\n" +
                "55808 gsvjgj.jsm\n" +
                "214300 wjv\n" +
                "$ cd ..\n" +
                "$ cd wjlfgt\n" +
                "$ ls\n" +
                "201399 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd jcffb\n" +
                "$ ls\n" +
                "81815 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd jzl\n" +
                "$ ls\n" +
                "155651 gsvjgj.jsm\n" +
                "dir shrf\n" +
                "$ cd shrf\n" +
                "$ ls\n" +
                "57545 fpljqj.pcb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nzlv\n" +
                "$ ls\n" +
                "115992 bmmnj.ghw\n" +
                "100862 ghtzhjwf.nls\n" +
                "dir qwjpjw\n" +
                "dir rhbtbjp\n" +
                "dir rlmzs\n" +
                "60695 szft.bjb\n" +
                "3260 vzgwmrnc\n" +
                "dir wwnnj\n" +
                "17546 zdstndwj.lms\n" +
                "$ cd qwjpjw\n" +
                "$ ls\n" +
                "dir dpwp\n" +
                "dir fzdcjr\n" +
                "173669 gsvjgj.jsm\n" +
                "dir nmnbv\n" +
                "dir nqfdhlcg\n" +
                "dir plzdzdnm\n" +
                "135543 qfwdmzfv.ggd\n" +
                "246217 qmrsvfvw\n" +
                "dir sgpcqqm\n" +
                "141900 wvt.rfz\n" +
                "$ cd dpwp\n" +
                "$ ls\n" +
                "214058 wjv.zqs\n" +
                "94614 zrtbln\n" +
                "$ cd ..\n" +
                "$ cd fzdcjr\n" +
                "$ ls\n" +
                "236058 jcn.fzn\n" +
                "$ cd ..\n" +
                "$ cd nmnbv\n" +
                "$ ls\n" +
                "215145 lllgsbb\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "61644 ghtzhjwf.nls\n" +
                "238094 qfwdmzfv.ggd\n" +
                "183057 szft.bjb\n" +
                "17501 wjv.pln\n" +
                "$ cd ..\n" +
                "$ cd plzdzdnm\n" +
                "$ ls\n" +
                "243979 fpljqj.lnj\n" +
                "$ cd ..\n" +
                "$ cd sgpcqqm\n" +
                "$ ls\n" +
                "262759 hjffwcls\n" +
                "100893 mvs.cgz\n" +
                "dir nzhlcl\n" +
                "170443 szft.bjb\n" +
                "dir zfl\n" +
                "$ cd nzhlcl\n" +
                "$ ls\n" +
                "dir wcfl\n" +
                "$ cd wcfl\n" +
                "$ ls\n" +
                "24502 mjfjqw.ccv\n" +
                "145029 zfl.lpp\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "176653 ghtzhjwf.nls\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rhbtbjp\n" +
                "$ ls\n" +
                "dir nqfdhlcg\n" +
                "232788 pmj.cmm\n" +
                "dir zfvbc\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "72379 gqpcrtpw.nsm\n" +
                "$ cd ..\n" +
                "$ cd zfvbc\n" +
                "$ ls\n" +
                "19204 dqbs.ddg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd rlmzs\n" +
                "$ ls\n" +
                "232862 fpljqj.rps\n" +
                "5558 lmgss.dtf\n" +
                "$ cd ..\n" +
                "$ cd wwnnj\n" +
                "$ ls\n" +
                "260417 cwjsrptm.hlm\n" +
                "216130 gsvjgj.jsm\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "dir hllbt\n" +
                "dir nqfdhlcg\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "dir qmrsvfvw\n" +
                "dir tdnp\n" +
                "dir vhtwd\n" +
                "dir wnlzd\n" +
                "dir ztttgd\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "218325 fpljqj.zhj\n" +
                "220402 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd tdnp\n" +
                "$ ls\n" +
                "46936 fmgz\n" +
                "dir gdsqdtw\n" +
                "dir tpcbjc\n" +
                "dir zfl\n" +
                "$ cd gdsqdtw\n" +
                "$ ls\n" +
                "128812 cnfpsb.qjr\n" +
                "185390 ghtzhjwf.nls\n" +
                "147220 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd tpcbjc\n" +
                "$ ls\n" +
                "188075 szft.bjb\n" +
                "243171 zdprcqs.qwf\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "dir nnschfl\n" +
                "dir qmrsvfvw\n" +
                "dir szlbls\n" +
                "109443 wjv\n" +
                "$ cd nnschfl\n" +
                "$ ls\n" +
                "139948 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "dir bdn\n" +
                "dir fpljqj\n" +
                "168508 fpljqj.ljd\n" +
                "dir hwgbwqmm\n" +
                "dir nwhl\n" +
                "224059 qfwdmzfv.ggd\n" +
                "$ cd bdn\n" +
                "$ ls\n" +
                "179118 jdrdjf.ppn\n" +
                "74443 lpp\n" +
                "$ cd ..\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "125033 mtfgm.pjf\n" +
                "$ cd ..\n" +
                "$ cd hwgbwqmm\n" +
                "$ ls\n" +
                "133673 vrvhgbz.ttb\n" +
                "$ cd ..\n" +
                "$ cd nwhl\n" +
                "$ ls\n" +
                "187017 fpljqj\n" +
                "149238 mjfjqw.ccv\n" +
                "dir mqzrmjr\n" +
                "dir vdjgqfc\n" +
                "dir zfzfbq\n" +
                "$ cd mqzrmjr\n" +
                "$ ls\n" +
                "dir fpljqj\n" +
                "131712 jmnsst.bmv\n" +
                "289722 ppdhjswn\n" +
                "dir qmrsvfvw\n" +
                "30641 zfl.trb\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "286985 lwmfmsr.tln\n" +
                "253325 mjfjqw.ccv\n" +
                "194077 vgb.glm\n" +
                "38905 wjv.vgs\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "87468 nngbnwds.qcn\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vdjgqfc\n" +
                "$ ls\n" +
                "122025 rnvwf.mrp\n" +
                "261944 wdwgml\n" +
                "$ cd ..\n" +
                "$ cd zfzfbq\n" +
                "$ ls\n" +
                "dir bwmrf\n" +
                "dir zfl\n" +
                "$ cd bwmrf\n" +
                "$ ls\n" +
                "222502 gsvjgj.jsm\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "10297 ghtzhjwf.nls\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd szlbls\n" +
                "$ ls\n" +
                "10968 bqbclc.nfl\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd vhtwd\n" +
                "$ ls\n" +
                "188024 dgz\n" +
                "$ cd ..\n" +
                "$ cd wnlzd\n" +
                "$ ls\n" +
                "201028 gsvjgj.jsm\n" +
                "dir mcnnsv\n" +
                "dir mctpdbs\n" +
                "47879 szft.bjb\n" +
                "dir tjqfts\n" +
                "164406 zpdmdrw\n" +
                "$ cd mcnnsv\n" +
                "$ ls\n" +
                "dir lclgj\n" +
                "dir sjdbnbqw\n" +
                "dir tlj\n" +
                "dir wjv\n" +
                "$ cd lclgj\n" +
                "$ ls\n" +
                "192605 fgpjczr.grp\n" +
                "65758 hhrf.fgg\n" +
                "$ cd ..\n" +
                "$ cd sjdbnbqw\n" +
                "$ ls\n" +
                "89058 ghtzhjwf.nls\n" +
                "191742 rlmwjg.dpl\n" +
                "179479 zswc.snt\n" +
                "$ cd ..\n" +
                "$ cd tlj\n" +
                "$ ls\n" +
                "183447 fpljqj.fgf\n" +
                "$ cd ..\n" +
                "$ cd wjv\n" +
                "$ ls\n" +
                "1517 pbwr\n" +
                "189647 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd mctpdbs\n" +
                "$ ls\n" +
                "120327 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd tjqfts\n" +
                "$ ls\n" +
                "dir crvw\n" +
                "$ cd crvw\n" +
                "$ ls\n" +
                "289523 lcshtlgf.lrv\n" +
                "169176 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ztttgd\n" +
                "$ ls\n" +
                "247914 sqqv.cvm\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd hllbt\n" +
                "$ ls\n" +
                "298155 cqnb.fgc\n" +
                "224277 hjf\n" +
                "220312 jhnpv\n" +
                "7421 qmrsvfvw\n" +
                "dir qsg\n" +
                "$ cd qsg\n" +
                "$ ls\n" +
                "dir drm\n" +
                "dir fpljqj\n" +
                "dir wjv\n" +
                "$ cd drm\n" +
                "$ ls\n" +
                "dir fhzr\n" +
                "$ cd fhzr\n" +
                "$ ls\n" +
                "dir nqfdhlcg\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "125578 nqfdhlcg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd fpljqj\n" +
                "$ ls\n" +
                "dir jmfqmdcm\n" +
                "dir nqfdhlcg\n" +
                "48942 qfwdmzfv.ggd\n" +
                "dir swrdzl\n" +
                "18483 szft.bjb\n" +
                "254012 zjcnz.pls\n" +
                "$ cd jmfqmdcm\n" +
                "$ ls\n" +
                "130015 bvrmp.vwg\n" +
                "157978 gsvjgj.jsm\n" +
                "54571 hmhldqr.ctt\n" +
                "169263 qgccqrqs\n" +
                "261388 szft.bjb\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "213466 fpljqj.wbp\n" +
                "31434 jhsb.lbb\n" +
                "144357 qfwdmzfv.ggd\n" +
                "$ cd ..\n" +
                "$ cd swrdzl\n" +
                "$ ls\n" +
                "dir fgmtnt\n" +
                "dir pnmz\n" +
                "280186 qmrsvfvw.mrb\n" +
                "$ cd fgmtnt\n" +
                "$ ls\n" +
                "95823 gsvjgj.jsm\n" +
                "127258 qmrsvfvw\n" +
                "$ cd ..\n" +
                "$ cd pnmz\n" +
                "$ ls\n" +
                "110479 ghtzhjwf.nls\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd wjv\n" +
                "$ ls\n" +
                "51754 jpwhctfd\n" +
                "174007 mgqplvv.hlt\n" +
                "45041 mtrfs.bhj\n" +
                "153169 vhjw.vbg\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd nqfdhlcg\n" +
                "$ ls\n" +
                "dir htnw\n" +
                "280499 tdwzsgqh.zsh\n" +
                "$ cd htnw\n" +
                "$ ls\n" +
                "203521 ggfpmb.pmz\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd zfl\n" +
                "$ ls\n" +
                "36860 mlbcw\n" +
                "dir rgvgqqd\n" +
                "239962 rpv.qhp\n" +
                "64500 zfl.mvw\n" +
                "$ cd rgvgqqd\n" +
                "$ ls\n" +
                "26778 qnhpfr\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd qmrsvfvw\n" +
                "$ ls\n" +
                "290013 gsvjgj.jsm\n" +
                "$ cd ..\n" +
                "$ cd svgbqd\n" +
                "$ ls\n" +
                "69927 bjc.vdh";
    }
}
