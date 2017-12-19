package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by 18435 on 2017/9/28.
 */
public class SortMountains {

    private LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>{
        @Override
        public int compare(Mountain o1, Mountain o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class HeightCompare implements Comparator<Mountain>{
        @Override
        public int compare(Mountain o1, Mountain o2) {
            return o2.getHeight().compareTo(o1.getHeight());
        }
    }

    public void go(){
        mtn.add(new Mountain("Longs",14255));
        mtn.add(new Mountain("Elbert",14433));
        mtn.add(new Mountain("Maroon",14156));
        mtn.add(new Mountain("Castle",14265));

        System.out.println("as entered:\n"+mtn);
        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc);
        System.out.println("by name:\n" + mtn);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("by height:\n" + mtn);
    }

    public static void main(String[] args){
        SortMountains sortMountains = new SortMountains();
        sortMountains.go();
    }
}
