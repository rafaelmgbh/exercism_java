public class Blackjack {


    public int parseCard(String card) {
        //Recebe a carta e retorna o valor dela
       switch (card) {
            case "ace":
                return 11;
            case "jack":
            case "queen":
            case "king":
            case "ten":
                return 10;
            case "nine":
                return 9;
            case "eight":
                return 8;
            case "seven":
                return 7;
            case "six":
                return 6;
            case "five":
                return 5;
            case "four":
                return 4;
            case "three":
                return 3;
            case "two":
                return 2;
            default:
                return 0;
        }
    }


    public boolean isBlackjack(String card1, String card2) {
        // Recebe duas cartas e retorna se é blackjack ou não

        if (card1.equals("ace")) {
            switch (card2) {
                case "queen":
                case "king":
                case "jack":
                case "ten":
                    return true;
            }
        }

        if (card2.equals("ace")) {
            switch (card1) {
                case "queen":
                case "king":
                case "jack":
                case "ten":
                    return true;
            }
        }
        return false;
    }


    public String largeHand(boolean isBlackjack, int dealerScore) {
        // Recebe se é blackjack e a pontuação do dealer e retorna se a mão é grande ou não

        if (isBlackjack) {
            switch (dealerScore) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return "W";
                default:
                    return "S";
            }
        } else {
            return "P";
        }
    }


    public String smallHand(int handScore, int dealerScore) {
        // Recebe a pontuação da mão e a pontuação do dealer e retorna se a mão é pequena ou não

        if (handScore >= 17) {
            return "S";
        } else if (handScore >= 12 && handScore <= 16) {
            if (dealerScore < 7) {
                return "S";
            } else {
                return "H";
            }
        } else {
            return "H";
        }
    }

    public String firstTurn(String card1, String card2, String dealerCard) {
        // Recebe as duas cartas e a carta do dealer e retorna a ação a ser tomada

        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }

}

