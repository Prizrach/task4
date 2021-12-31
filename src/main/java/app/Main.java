package app;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//
//            String john = null;
//            Optional<String> name = Optional.ofNullable(john);
//            System.out.println(name); //output Optional.empty

        Optional<String> name = Optional.ofNullable("John");
        System.out.println(name); //output Optional[John]



    }
}
