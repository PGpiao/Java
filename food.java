public class food {
//    String food_name;
//    String food_type;
//    String food_value;

//    public food(String name,String type,String value) {
//        this.food_name = name;
//        this.food_type = type;
//        this.food_value = value;
//    }
    public static class coffee{
        String coffee_name="coffee";
        String coffee_type="aroma";
        String coffee_value="насыщенный, горький, восточный";
        String getfood(){
            return coffee_name;

    }

//        food coffee=new food("coffee","aroma","насыщенный, горький, восточный");
    }
//    public class tea{
//        food coffee=new food("coffee","aroma","насыщенный, горький, восточный");

//    }
    public static void main(String[] args) {
    //茶叶
        food food1 = new food();
        food.coffee coffee = new food.coffee();

    System.out.println(coffee.getfood());
//        food tea=new food("Tea","color","balck,green");
//        food coffee=new food("coffee","aroma","насыщенный, горький, восточный");
//        System.out.println("name: "+tea.food_name+"\n"+tea.food_type+": "+ tea.food_value);
        System.out.println("name: "+coffee.coffee_name+"\n type "+ coffee.coffee_type+"\nValue: " +coffee.coffee_value);

//        System.out.println("name: "+coffee.food_name+"\n"+coffee.food_type+": "+ coffee.food_value);
    }


}


