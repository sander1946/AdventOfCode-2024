package com.advent.of.code;

import java.util.ArrayList;
import java.util.Arrays;

public class RaportList extends ArrayList<Raport> {
    
    public RaportList() {
        super();
    }

    public RaportList(int initialCapacity) {
        super(initialCapacity);
    }

    public RaportList(RaportList raportList) {
        super(raportList);
    }
    
    public RaportList(ArrayList<Raport> list) {
        super(list);
    }
    
    public RaportList(Raport[] array) {
        this.addAll(Arrays.asList(array));
    }

    public void addRaport(Raport raport) {
        this.add(raport);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Raport raport : this) {
            sb.append(raport.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
