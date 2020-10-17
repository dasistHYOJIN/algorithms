package hacker_rank;

public class TheTimeInWords {
    public static void main(String[] args) {
        System.out.println(timeInWords(12, 12));
        System.out.println(timeInWords(5, 0));
        System.out.println(timeInWords(5, 30));
        System.out.println(timeInWords(5, 45));
        System.out.println(timeInWords(5, 47));
        System.out.println(timeInWords(6, 35));
    }

    static String timeInWords(int h, int m) {
        if (m > 30) {
            h += 1;
            m -= 60;
        }

        StringBuilder result = new StringBuilder();

        if (m != 0) {
            if (m == 30) {
                result.append("half ");
            } else {
                result.append(minute(Math.abs(m)));
            }
            result.append((m < 0) ? "to " : "past ");
        }
        result.append(hour(h));
        if (m == 0) {
            result.append("o' clock");
        }

        return result.toString().trim();
    }

    private static String minute(int m) {
        if (m == 15) return "quarter ";

        StringBuilder result = new StringBuilder();

        if (m >= 10 && m <= 19) {
            if (m == 11) result.append("eleven ");
            else if (m == 12) result.append("twelve ");
            else if (m == 13) result.append("thirteen ");
            else if (m == 14) result.append("fourteen ");
            else if (m == 16) result.append("sixteen ");
            else if (m == 17) result.append("seventeen ");
            else if (m == 18) result.append("eighteen ");
            else if (m == 19) result.append("nineteen ");
            else result.append("ten ");
        } else {
            switch (m / 10) {
                case 2:
                    result.append("twenty ");
                    break;
                case 3:
                    result.append("thirty ");
                    break;
                case 4:
                    result.append("forty ");
                    break;
                case 5:
                    result.append("fifty ");
                    break;
                case 6:
                    result.append("sixty ");
                    break;
                case 7:
                    result.append("seventy ");
                    break;
                case 8:
                    result.append("eighty ");
                    break;
                case 9:
                    result.append("ninety ");
                    break;
            }

            switch (m % 10) {
                case 1:
                    result.append("one ");
                    break;
                case 2:
                    result.append("two ");
                    break;
                case 3:
                    result.append("three ");
                    break;
                case 4:
                    result.append("four ");
                    break;
                case 5:
                    result.append("five ");
                    break;
                case 6:
                    result.append("six ");
                    break;
                case 7:
                    result.append("seven ");
                    break;
                case 8:
                    result.append("eight ");
                    break;
                case 9:
                    result.append("nine ");
                    break;
            }

        }

        result.append((m > 1) ? "minutes " : "minute ");
        return result.toString();
    }

    private static String hour(int h) {
        switch (h) {
            case 1:
                return "one ";
            case 2:
                return "two ";
            case 3:
                return "three ";
            case 4:
                return "four ";
            case 5:
                return "five ";
            case 6:
                return "six ";
            case 7:
                return "seven ";
            case 8:
                return "eight ";
            case 9:
                return "nine ";
            case 10:
                return "ten ";
            case 11:
                return "eleven ";
            default:
                return "twelve ";
        }
    }

}
