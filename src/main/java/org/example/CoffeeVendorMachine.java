package org.example;

import java.util.Scanner;

public  class  CoffeeVendorMachine {
    private int water;
    private int beans;
    private int milk;
    private int money;
    private int espressoWater;
    private int espressoBeans;
    private int latteWater;
    private int latteMilk;
    private int latteBeans;
    private int cappuccinoWater;
    private int cappuccinoMilk;
    private int cappuccinoBeans;
    private int espressoPrice;
    private int lattePrice;
    private int cappuccinoPrice;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;
    private int totalEarnings;

    public CoffeeVendorMachine() {
         water = 0;
         beans = 0;
         milk = 0;
         money = 0;
         espressoWater = 250;
         espressoBeans = 16;
         latteWater = 350;
         latteMilk = 75;
         latteBeans = 20;
         cappuccinoWater = 200;
         cappuccinoMilk = 100;
         cappuccinoBeans = 12;
         espressoPrice = 4;
         lattePrice = 7;
         cappuccinoPrice = 6;
         espressoCount = 0;
         latteCount = 0;
         cappuccinoCount = 0;
         totalEarnings = 0;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            System.out.println("Please select an action:");
            System.out.println("1. Buy Coffee");
            System.out.println("2. Fill Ingredients ");
            System.out.println("3. Take Money");
            System.out.println("4. Show Ingredients and Money in Machine");
            System.out.println("5. Analytics");
            System.out.println("0. Exit");
            command = sc.nextLine();
            switch (command) {
                case "1":
                    buyCoffee(sc);
                    break;
                case "2":
                    fillIngredients(sc);
                    break;
                case "3":
                    takeMoney();
                    break;
                case "4":
                    showIngredients();
                    break;
                case "5":
                    showAnalytics();
                    break;
                case "0":
                    System.out.println("Exiting the simulator...");
                    break;
                default:
                    System.out.println("Invalid command! Please try again.");
                    break;
            }
        } while (!command.equals("0"));
        sc.close();
    }

    private void buyCoffee(Scanner scn) {

        System.out.println("Please select a coffee type:");
        System.out.println("1. Espresso ($" + espressoPrice + ")");
        System.out.println("2. Latte ($" + lattePrice + ")");
        System.out.println("3. Cappuccino ($" + cappuccinoPrice + ")");

        System.out.println("0 -> Back");
        String coffeeTyped = scn.nextLine();
        switch (coffeeTyped) {
            case "1":
                makeCoffee("Espresso");
                break;
            case "2":
                makeCoffee("Latte");
                break ;
            case "3":
                makeCoffee("Cappuccino");
                break;
            case "0":
                makeCoffee("Returning to main menu");
                break;
            default:
                System.out.println("Please Select Valid Coffee");
                break;
        }
    }

    private void makeCoffee(String coffeeTyped) {
        if (coffeeTyped.equals("Espresso") && haveEnough(espressoWater, 0, espressoBeans)) {
            System.out.println("Your Espresso Coffee is Ready");

            water -= espressoWater;
            beans -= espressoBeans;
            money += espressoPrice;
            espressoCount++;
            totalEarnings += espressoPrice;

        } else if (coffeeTyped.equals("Latte") && haveEnough(latteWater, latteMilk, latteBeans)) {
            System.out.println("Your Latte will ready soon");
            water -= latteWater;
            milk -= latteMilk;
            beans -= latteBeans;
            money += lattePrice;
            latteCount++;
            totalEarnings += lattePrice;

        } else if (coffeeTyped.equals("Cappuccino") && haveEnough(cappuccinoWater, cappuccinoMilk, cappuccinoBeans)) {
            System.out.println("Your Cappuccino will ready soon");
            water -= cappuccinoWater;
            milk -= cappuccinoMilk;
            beans -= cappuccinoBeans;
            money += cappuccinoPrice;
            cappuccinoCount++;
            totalEarnings += cappuccinoPrice;

        }else {
            System.out.println("Insufficient ingredients to make " + coffeeTyped+ "! Please refill.");
        }
    }

    private boolean haveEnough(int requiredWater, int requiredMilk, int requiredBeans) {
        return water >= requiredWater && milk >= requiredMilk && beans >= requiredBeans;
    }

    private void fillIngredients(Scanner scn) {
        System.out.println("Enter Amount water you need to add");
        int waterAdd = scn.nextInt();
        System.out.println("Enter Amount Milk you need to add");
        int milkAdd = scn.nextInt();
        System.out.println("Enter Amount Beans you need to add");
        int beansAdd = scn.nextInt();
        scn.nextLine();
        water += waterAdd;
        milk += milkAdd;
        beans += beansAdd;
        System.out.println("Ingredient added Successfully");
    }

    private void takeMoney() {
        System.out.println("Money Collected Rs." + money);
        money = 0;
    }

    private void showIngredients() {
        System.out.println("Water : Rs. " + water + "ml");
        System.out.println("Milk : Rs. " + milk + "ml");
        System.out.println("Beans :Rs. " + beans + " Unite");
        System.out.println("Final Bill : Rs. " + money);
    }

    private void showAnalytics() {
        System.out.println("Espresso Sold" + espressoCount);
        System.out.println("Latte Sold" + latteCount);
        System.out.println("Cappuccino Sold" + cappuccinoCount);
        System.out.println("Total Ingredient Consumed");
        System.out.println("Water -> " + espressoCount * espressoWater + latteCount * latteWater + cappuccinoCount * cappuccinoWater);
        System.out.println("Milk -> " + latteCount * latteMilk + latteCount * latteBeans);
        System.out.println("Beans -> " + cappuccinoCount * cappuccinoWater + cappuccinoCount * cappuccinoMilk + cappuccinoCount * cappuccinoBeans);
    }

    public static void main(String[] args) {
        CoffeeVendorMachine coffeeVendorMachine=new CoffeeVendorMachine();
        coffeeVendorMachine.run();
          }
    }