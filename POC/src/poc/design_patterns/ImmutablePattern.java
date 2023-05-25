package poc.design_patterns;

import java.util.ArrayList;
import java.util.List;

public class ImmutablePattern {
    private final int id;
    private final List<String> list;

    public ImmutablePattern(int a, List<String> l){

        this.id = a;
        if( l == null ) throw new RuntimeException("List cannot be null");

        this.list = new ArrayList<>(l);
    }

    public int getId(){
        return id;
    }

    public String getListElement(int index){
        return this.list.get(index);
    }

    public int getSize(){
        return this.list.size();
    }

}
