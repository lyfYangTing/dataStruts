package test;

/**
 * Created by 18435 on 2017/9/28.
 */
public class Mountain {

    private String name;
    private Integer height;

    public Mountain(){}

    public Mountain(String name,Integer height){
        this.height = height;
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.name+""+this.getHeight();
    }
}
