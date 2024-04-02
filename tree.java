package fibonacci;
import java.util.*;

public class tree {

    abstract static class Item {
        protected String name;
        public Item(String name) {
            this.name = name;
        }
        abstract void display(String prefix, boolean isLast, boolean isBullet);
    }

    static class Category extends Item {
        private List<Item> children;
        public Category(String name) {
            super(name);
            children = new ArrayList<>();
        }
        public void addChild(Item item) {
            children.add(item);
        }
        @Override
        void display(String prefix, boolean isLast, boolean isBullet) {
            String connector = isLast ? "└── " : "├── ";
            System.out.println(prefix + (isBullet ? "• " : connector) + name);
            for (int i = 0; i < children.size() - 1; i++)
                children.get(i).display(prefix + (isLast ? "    " : "│   "), false, isBullet);
            if (!children.isEmpty())
                children.get(children.size() - 1).display(prefix + (isLast ? "    " : "│   "), true, isBullet);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Category> selectedCategories = new ArrayList<>();
        System.out.println("Select the types of food you want to include in the hierarchy:");
        System.out.println("1. Food");
        System.out.println("2. Beverage");
        System.out.println("3. Dairy Product");
        System.out.println("4. Meat");
        System.out.println("5. Fruit");
        System.out.println("6. Vegetable");
        System.out.println("7. Condiments");
        System.out.println("Enter the numbers separated by spaces:");

        String[] selectedTypes = scanner.nextLine().split(" ");
        scanner.nextLine(); // Consume the newline character
        for (String type : selectedTypes) {
            switch (type) {
                case "1":
                    selectedCategories.add(createFoodCategory());
                    break;
                case "2":
                    selectedCategories.add(createBeverageCategory());
                    break;
                case "3":
                    selectedCategories.add(createDairyCategory());
                    break;
                case "4":
                    selectedCategories.add(createMeatCategory());
                    break;
                case "5":
                    selectedCategories.add(createFruitCategory());
                    break;
                case "6":
                    selectedCategories.add(createVegetableCategory());
                    break;
                case "7":
                    selectedCategories.add(createCondimentsCategory());
                    break;
                default:
                    System.out.println("Invalid selection: " + type);
            }
        }

        System.out.println("How would you like to display the hierarchy?");
        System.out.println("1. Bullet points");
        System.out.println("2. Tree");
        System.out.print("Enter your choice: ");

        int displayChoice = scanner.nextInt();

        Category rootCategory = new Category("Root");
        for (Category category : selectedCategories) {
            rootCategory.addChild(category);
        }

        if (displayChoice == 1) {
            System.out.println("Item Display as Bullet Points:");
            rootCategory.display("", true, true);
        } else {
            System.out.println("Item Display as Tree:");
            rootCategory.display("", true, false);
        }
    }

    // Helper methods to create categories
    private static Category createFoodCategory() {
        Category foodCategory = new Category("Food");
        foodCategory.addChild(new Category("Apple"));
        foodCategory.addChild(new Category("Banana"));
        foodCategory.addChild(new Category("Beef"));
        foodCategory.addChild(new Category("Butter"));
        foodCategory.addChild(new Category("Carrots"));
        foodCategory.addChild(new Category("Cheese"));
        foodCategory.addChild(new Category("Chicken"));
        foodCategory.addChild(new Category("Cocoa"));
        foodCategory.addChild(new Category("Egg"));
        foodCategory.addChild(new Category("Fish"));
        foodCategory.addChild(new Category("Green Bean"));
        foodCategory.addChild(new Category("Grapes"));
        foodCategory.addChild(new Category("Lettuce"));
        foodCategory.addChild(new Category("Milk"));
        foodCategory.addChild(new Category("Orange Juice"));
        foodCategory.addChild(new Category("Pineapple"));
        foodCategory.addChild(new Category("Pork"));
        foodCategory.addChild(new Category("Rice"));
        foodCategory.addChild(new Category("Shake"));
        foodCategory.addChild(new Category("Shrimp"));
        foodCategory.addChild(new Category("Spinach"));
        foodCategory.addChild(new Category("Tomato"));
        return foodCategory;
    }

    private static Category createBeverageCategory() {
        Category beverageCategory = new Category("Beverage");
        beverageCategory.addChild(new Category("Orange Juice"));
        beverageCategory.addChild(new Category("Shake"));
        return beverageCategory;
    }

    private static Category createDairyCategory() {
        Category dairyCategory = new Category("Dairy Product");
        dairyCategory.addChild(new Category("Milk"));
        dairyCategory.addChild(new Category("Yogurt Cream"));
        return dairyCategory;
    }

    private static Category createMeatCategory() {
        Category meatCategory = new Category("Meat");
        meatCategory.addChild(new Category("Beef"));
        meatCategory.addChild(new Category("Chicken"));
        meatCategory.addChild(new Category("Pork"));
        meatCategory.addChild(new Category("Poultry"));
        return meatCategory;
    }

    private static Category createFruitCategory() {
        Category fruitCategory = new Category("Fruit");
        fruitCategory.addChild(new Category("Apple"));
        fruitCategory.addChild(new Category("Banana"));
        fruitCategory.addChild(new Category("Grapes"));
        fruitCategory.addChild(new Category("Orange"));
        fruitCategory.addChild(new Category("Pineapple"));
        return fruitCategory;
    }

    private static Category createVegetableCategory() {
        Category vegetableCategory = new Category("Vegetable");
        vegetableCategory.addChild(new Category("Carrots"));
        vegetableCategory.addChild(new Category("Green Bean"));
        vegetableCategory.addChild(new Category("Lettuce"));
        vegetableCategory.addChild(new Category("Spinach"));
        vegetableCategory.addChild(new Category("Tomato"));
        return vegetableCategory;
    }

    private static Category createCondimentsCategory() {
        Category condimentsCategory = new Category("Condiments");
        condimentsCategory.addChild(new Category("Cocoa"));
        condimentsCategory.addChild(new Category("Fish Sauce"));
        condimentsCategory.addChild(new Category("Shrimp Paste"));
        condimentsCategory.addChild(new Category("Soy Sauce"));
        return condimentsCategory;
    }
}
