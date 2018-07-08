package leetcode.string;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-6-25
 */
public class Integer2EnglishWords {

    public static void main(String[] args) {
        Integer2EnglishWords i = new Integer2EnglishWords();
        System.out.println(i.numberToWords(12345));
    }

    public String numberToWords(int num) {

        String[] unit = new String[] {
                "", "Thousand", "Million", "Billion"
        };
        int index=0;
        int digit=0;

        StringBuffer buffer = new StringBuffer();

        while(num!=0) {
            String u=unit[index];
            if(digit==0 && num%1000 !=0) {
                buffer.insert(0, " "+ u);
            }
//            System.out.println(num + "\t" + digit);
            if(digit==0 && (num%100)/10==1) {
                digit=2;
                buffer.insert(0, " " + getTwoDigits(num%100));
                num=num/100;
            } else if(digit==0) {
                digit++;
                buffer.insert(0, " " + getGe(num%10));
                num/=10;
            } else if(digit==1) {
                digit++;
                buffer.insert(0, " " + getShi(num%10));
                num/=10;
            } else if(digit==2) {
                digit=0;
                if(!getGe(num%10) .equals("")) {
                    buffer.insert(0, " " + getGe(num%10) + " Hundred");
                }
                num/=10;
                index++;
            }
        }
        return buffer.toString().trim();
    }

    private String getGe(int data) {
        switch(data) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    private String getShi(int data) {
        switch(data) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }

    private String getTwoDigits(int data) {
        if(data==10) {
            return "Ten";
        } else if(data==11) {
            return "Eleven";
        } else if(data==12) {
            return "Twelve";
        } else if(data==13) {
            return "Thirteen";
        } else if(data==14) {
            return "Fourteen";
        } else if(data==15) {
            return "Fifteen";
        } else if(data==16) {
            return "Sixteen";
        } else if(data==17) {
            return "Seventeen";
        } else if(data==18) {
            return "Eighteen";
        } else if(data==19) {
            return "Nineteen";
        }
        return "";
    }
}
