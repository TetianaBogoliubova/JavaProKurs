package homework_23_09_27_roulette;

import java.util.*;

public class GameProcess {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Player player = new Player();

    private int currentQuantityGitons;// текущее количество жетонов, после каждой ставки
    private int numSerios;//порядковый номер серии, который вводит игрок
    private int numComplit;//порядковый номер комплита, который вводит игрок
    private int numFromComplit;// число, выбранное игроком в пределах комплита

    public int getNumSerios() {
        return numSerios;
    }

    public int getNumComplit() {
        return numComplit;
    }

    public int getNumFromComplit() {
        return numFromComplit;
    }

    public void putBetOnColor() {
        String[] colors = {"red", "black"};

        System.out.println("Введите количество жетонов для ставки на цвет");
        player.setGitonsCount(scanner.nextInt()); //сколько игрок ставит жeтонов
        scanner.nextLine();

        System.out.println("Попробуйте выиграть, поставив на red или black");
        player.setInputSection(scanner.nextLine());
        int indexArr = random.nextInt(colors.length);
        System.out.println("Выиграл цвет: " + colors[indexArr]);

        if (player.getInputSection().equalsIgnoreCase(colors[indexArr])) {
            currentQuantityGitons = (player.getQuantityGitons() + player.getGitonsCount());
            System.out.println("Поздравляем! Вы выиграли: " + player.getGitonsCount() + " жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
        } else {
            currentQuantityGitons = player.getQuantityGitons() - player.getGitonsCount();
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + currentQuantityGitons + " жетонов");
        }
    }

    public void putBetOnSection() {
        String[] sections = {"even", "odd"};

        System.out.println("Введите количество жетонов для ставки на секцию");
        player.setGitonsCount(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Вы можете сделать ставку на even или odd");
        player.setInputSection(scanner.nextLine());
        int indexArr = random.nextInt(sections.length);
        System.out.println("Выиграл сектор: " + sections[indexArr]);

        if (player.getInputSection().equalsIgnoreCase(sections[indexArr])) {
            currentQuantityGitons = currentQuantityGitons + player.getGitonsCount();
            System.out.println("Поздравляем! Вы выиграли: " + player.getGitonsCount() + " жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");

        } else {
            currentQuantityGitons = currentQuantityGitons - player.getGitonsCount();
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + currentQuantityGitons + " жетонов");
        }
    }

    public void putBetOnNumber() {
        System.out.println("Введите количество жетонов для ставки на номер");
        player.setGitonsCount(scanner.nextInt());
        System.out.println("Выберете номер, на который хотите поставить");
        player.setInputNumber(scanner.nextInt());
        player.setWinNumber(random.nextInt(0, 37));
        System.out.println("Выиграл номер: " + player.getWinNumber());

        if (player.getInputNumber() < 0 || player.getInputNumber() > 36) {
            System.out.println("Вы ввели неправильный номер.");

        } else if (player.getInputNumber() == player.getWinNumber()) {
            currentQuantityGitons = (currentQuantityGitons + (player.getGitonsCount() * 35));
            System.out.println("Поздравляем! Вы выиграли: " + (player.getGitonsCount() * 35) + " жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");

        } else {
            currentQuantityGitons = currentQuantityGitons - player.getGitonsCount();
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + currentQuantityGitons + " жетонов");
        }
    }

    public void playWithSeries() {

        System.out.println("Сделайте ставку на серию по ее порядковому номеру: \n 1 - Большая серия, \n 2 - Малая серия, \n 3 - Орфлайнс, \n 4 - Зеро-шпиль");
        numSerios = player.setInputSerios(scanner.nextInt());

        player.setWinNumber(random.nextInt(12, 13));

        if (numSerios == 1) {
            getBigSeries();
        } else if (numSerios == 2) {
            getSmallSeries();
        } else if (numSerios == 3) {
            getOrphelins();
        } else if (numSerios == 4) {
            getZeroSpiel();
        }
        System.out.println("Выиграл номер: " + player.getWinNumber());
    }

    public void getBigSeries() {
        if (currentQuantityGitons < 9) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        int[] bigSeries = {4, 7, 12, 15, 18, 21, 19, 22, 32, 35};
        boolean winBet = false;

        if (currentQuantityGitons >= 9) {
            for (int i : bigSeries) {
                if (player.getWinNumber() == i && numSerios == 1) {
                    currentQuantityGitons = currentQuantityGitons - 8 + 17;
                    System.out.println("Поздравляем! Вы выиграли 17 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                } else if ((player.getWinNumber() == 0 || player.getWinNumber() == 2 || player.getWinNumber() == 3)) {
                    currentQuantityGitons = currentQuantityGitons - 7 + 22;
                    System.out.println("Поздравляем! Вы выиграли 22 жетона! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                } else if ((player.getWinNumber() == 25 || player.getWinNumber() == 26 || player.getWinNumber() == 28 || player.getWinNumber() == 29)) {
                    currentQuantityGitons = currentQuantityGitons - 7 + 16;
                    System.out.println("Поздравляем! Вы выиграли 16 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                }
            }
            if (!winBet) {
                System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 9) + " жетонов");
            }
        }
    }

    public void getSmallSeries() {
        if (currentQuantityGitons < 6) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        int[] smallSeries = {5, 8, 10, 11, 13, 16, 23, 24, 27, 30, 33, 36};
        boolean winBet = false;

        if (currentQuantityGitons >= 6) {
            for (int i : smallSeries) {
                if (player.getWinNumber() == i) {
                    currentQuantityGitons = currentQuantityGitons - 5 + 17;
                    System.out.println("Поздравляем! Вы выиграли 17 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                }
            }
            if (!winBet) {
                System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 6) + " жетонов");
            }
        }
    }

    public void getOrphelins() {
        if (currentQuantityGitons < 5) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        int[] orphelins = {6, 9, 14, 20, 31, 34};
        boolean winBet = false;

        if (currentQuantityGitons >= 5) {
            for (int i : orphelins) {
                if (player.getWinNumber() == i) {
                    currentQuantityGitons = currentQuantityGitons - 4 + 17;
                    System.out.println("Поздравляем! Вы выиграли 17 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                } else if (player.getWinNumber() == 1) {
                    currentQuantityGitons = currentQuantityGitons - 4 + 35;
                    System.out.println("Поздравляем! Вы выиграли 35 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                } else if (player.getWinNumber() == 17) {
                    currentQuantityGitons = currentQuantityGitons - 3 + 34;
                    System.out.println("Поздравляем! Вы выиграли 34 жетона! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                }
            }
            if (!winBet) {
                System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 5) + " жетонов");
            }
        }
    }

    public void getZeroSpiel() {
        if (currentQuantityGitons < 5) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        int[] zeroSpiel = {0, 3, 12, 15, 32, 35};
        boolean winBet = false;

        if (currentQuantityGitons >= 5) {
            for (int i : zeroSpiel) {
                if (player.getWinNumber() == i) {
                    currentQuantityGitons = currentQuantityGitons - 3 + 17;
                    System.out.println("Поздравляем! Вы выиграли 17 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                } else if (player.getWinNumber() == 26) {
                    currentQuantityGitons = currentQuantityGitons - 3 + 35;
                    System.out.println("Поздравляем! Вы выиграли 35 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                    winBet = true;
                    break;
                }
            }
            if (!winBet) {
                System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 4) + " жетонов");
            }
        }
    }

    public void playWithComplit1() {
        System.out.println("Попробуйте сделать ставку Complit на число, которая позволит Вам выиграть максимальное колличество жетонов");
        System.out.println("Выберете ставку на Complit по ее порядковому номеру: \n 1 - Complit на 0, \n 2 - Complit на 1 или 3, \n 3 - Complit на 2, \n 4 - Complit на числа из средней коллоны, \n 5 - Complit на числа из боковых колонн, \n 6 - Complit на 34 или 36, \n 7 - Complit на 35");
        numComplit = player.setInputSerios(scanner.nextInt());
        System.out.println("Выберете номер из данного комплита, на который Вы хотите поставить");
        numFromComplit = player.setInputNumber(scanner.nextInt());
        player.setWinNumber(random.nextInt(0, 37));

        if (numComplit == 1 && currentQuantityGitons >= 17) {
            getComplitZero();
        } else if (numComplit == 1 && currentQuantityGitons < 17) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 2 && currentQuantityGitons >= 27) {
            getComplitOwnAndTree();
        } else if (numComplit == 2 && currentQuantityGitons < 27) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 3 && currentQuantityGitons >= 36) {
            getComplitTwo();
        } else if (numComplit == 3 && currentQuantityGitons < 36) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 4 && currentQuantityGitons >= 40) {
            getComplitAverageColumn();
        } else if (numComplit == 4 && currentQuantityGitons < 40) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 5 && currentQuantityGitons >= 30) {
            complitSideColumn();
        } else if (numComplit == 5 && currentQuantityGitons < 30) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 6 && currentQuantityGitons >= 18) {
            getComplitThirtyFourAndThirtySix();
        } else if (numComplit == 6 && currentQuantityGitons < 24) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        if (numComplit == 7 && currentQuantityGitons >= 18) {
            getComplitThirtyFive();
        } else if (numComplit == 7 && currentQuantityGitons < 18) {
            System.out.println("Для этой ставки Вам не хватает жетонов");
        }
        System.out.println("Выиграл номер: " + player.getWinNumber());
    }

    public void getComplitZero() {
        boolean winBet = false;
        if (numFromComplit == 0 && numFromComplit == player.getWinNumber()) {
            currentQuantityGitons = currentQuantityGitons + 235;
            System.out.println("Поздравляем! Вы выиграли 235 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
            winBet = true;
        }
        if (!winBet) {
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 17));
        }
    }

    public void getComplitOwnAndTree() {
        boolean winBet = false;
        if ((numFromComplit == 1 || numFromComplit == 3) && numFromComplit == player.getWinNumber()) {
            currentQuantityGitons = currentQuantityGitons + 297;
            System.out.println("Поздравляем! Вы выиграли 297 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
            winBet = true;
        }
        if (!winBet) {
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 27));
        }
    }

    public void getComplitTwo() {
        if (numFromComplit == 2 && numFromComplit == player.getWinNumber()) {
            currentQuantityGitons = currentQuantityGitons + 396;
            System.out.println("Поздравляем! Вы выиграли 396 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
        } else System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 36));
    }

    public void getComplitAverageColumn() {
        int[] averageColumn = {5, 8, 11, 14, 17, 20, 23, 26, 29, 32};
        boolean winBet = false;
        for (int i : averageColumn) {
            if (numFromComplit == i && numFromComplit == player.getWinNumber()) {
                currentQuantityGitons = currentQuantityGitons + 392;
                System.out.println("Поздравляем! Вы выиграли 392 жетона! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                winBet = true;
            }
        }
        if (!winBet) {
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 40));
        }
    }

    public void complitSideColumn() {
        int[] sideColumn = {4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33};
        boolean winBet = false;
        for (int i : sideColumn) {
            if (numFromComplit == i && numFromComplit == player.getWinNumber()) {
                currentQuantityGitons = currentQuantityGitons + 294;
                System.out.println("Поздравляем! Вы выиграли 294 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
                winBet = true;
            }
        }
        if (!winBet) {
            System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 30));
        }
    }

    public void getComplitThirtyFourAndThirtySix() {
        if ((numFromComplit == 34 || numFromComplit == 36) && numFromComplit == player.getWinNumber()) {
            currentQuantityGitons = currentQuantityGitons + 198;
            System.out.println("Поздравляем! Вы выиграли 198 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
        } else System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 18));
    }

    public void getComplitThirtyFive() {
        if (numFromComplit == 35 && numFromComplit == player.getWinNumber()) {
            currentQuantityGitons = currentQuantityGitons + 264;
            System.out.println("Поздравляем! Вы выиграли 264 жетонов! У Вас сейчас всего: " + currentQuantityGitons + " жетонов");
        } else System.out.println("К сожалению, Вы проиграли. У Вас осталось: " + (currentQuantityGitons - 24));
    }
}

