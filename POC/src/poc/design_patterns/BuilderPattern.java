package poc.design_patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderPattern {
}

class CarBuilder extends BuilderPattern{
    private String carClass;
    private List<String> list;

    public CarBuilder(){ }

    public CarBuilder setCarClass(String clas){
        this.carClass = clas;
        return this;
    }

    public CarBuilder setList(List<String> l){
        this.list = l;
        return this;
    }

    public Cars build(){
        return new Cars(carClass, list);
    }
}

class Cars{
    private final String carClass;
    private final List<String> list;

    public Cars(String clas, List<String> l){

        if( l == null ) throw new RuntimeException("List passed cannot be null");

        this.carClass = clas;
        this.list = new ArrayList<>(l);
    }

    public String getCarClass(){
        return carClass;
    }

    public String getListIndex(int index){
        return list.get(index);
    }
}

class Consumer{

    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();
        carBuilder.setCarClass("Sedan")
                .setList(Arrays.asList("Tata Altroz", "Mahindra Verito"))
                .build();

    }
}
