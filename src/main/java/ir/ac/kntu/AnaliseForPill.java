package ir.ac.kntu;

public class AnaliseForPill {
    static int xElement = 0;

    static int yElement = 0;

    public static void putColorForPills(Pill pill) {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 227 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 245.75) {
            ProcessPosition.part1();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 245.75 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 264.5) {
            part11();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 264.5 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 283.25) {
            part111();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 283.25 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 302) {
            partT1();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 302 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 320.75) {
            partT11();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 320.75 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 339.5) {
            partT111();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 339.5 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 358.25) {
            partTT1();
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 > 358.25 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + 7 < 377) {
            partTT11();
        }
        MainGame.getColor()[xElement][yElement] = pill.getColor();
        MainGame.getNumberOfPanes()[xElement][yElement] = Medicine.getPanes().size() - 1;
    }

    private static void partTT22() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 7;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 7;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 7;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 7;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 7;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 7;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 7;
            yElement = 15;
        }
    }

    private static void partTT11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 7;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 7;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 7;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 7;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 7;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 7;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 7;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 7;
            yElement = 7;
        } else {
            tT11();
        }
    }

    private static void tT11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 7;
            yElement = 8;
        } else {
            partTT22();
        }
    }

    private static void partTT2() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 6;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 6;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 6;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 6;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 6;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 6;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 6;
            yElement = 15;
        }
    }

    private static void partTT1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 6;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 6;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 6;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 6;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 6;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 6;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 6;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 6;
            yElement = 7;
        } else {
            tT1();
        }
    }

    private static void tT1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 6;
            yElement = 8;
        } else {
            partTT2();
        }
    }

    private static void partT222() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 5;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 5;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 5;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 5;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 5;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 5;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 5;
            yElement = 15;
        }
    }

    private static void partT111() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 5;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 5;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 5;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 5;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 5;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 5;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 5;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 5;
            yElement = 7;
        } else {
            t111();
        }
    }

    private static void t111() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 5;
            yElement = 8;
        } else {
            partT222();
        }
    }

    private static void partT22() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 4;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 4;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 4;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 4;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 4;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 4;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 4;
            yElement = 15;
        }
    }

    private static void partT11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 4;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 4;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 4;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 4;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 4;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 4;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 4;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 4;
            yElement = 7;
        } else {
            t11();
        }
    }

    private static void t11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 4;
            yElement = 8;
        } else {
            partT22();
        }
    }

    private static void partT2() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 3;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 3;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 3;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 3;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 3;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 3;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 3;
            yElement = 15;
        }
    }

    private static void partT1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 3;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 3;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 3;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 3;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 3;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 3;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 3;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 3;
            yElement = 7;
        } else {
            t1();
        }
    }

    private static void t1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 3;
            yElement = 8;
        } else {
            partT2();
        }
    }

    private static void part222() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 2;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 2;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 2;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 2;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 2;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 2;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 2;
            yElement = 15;
        }
    }

    private static void part111() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 2;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 2;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 2;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 2;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 2;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 2;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 2;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 2;
            yElement = 7;
        } else {
            p111();
        }
    }

    private static void p111() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 2;
            yElement = 8;
        } else {
            part222();
        }
    }

    private static void part22() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            xElement = 1;
            yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            xElement = 1;
            yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            xElement = 1;
            yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            xElement = 1;
            yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            xElement = 1;
            yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            xElement = 1;
            yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            xElement = 1;
            yElement = 15;
        }
    }

    private static void part11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            xElement = 1;
            yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            xElement = 1;
            yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            xElement = 1;
            yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            xElement = 1;
            yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            xElement = 1;
            yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            xElement = 1;
            yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            xElement = 1;
            yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            xElement = 1;
            yElement = 7;
        } else {
            p11();
        }
    }

    private static void p11() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            xElement = 1;
            yElement = 8;
        } else {
            part22();
        }
    }

}