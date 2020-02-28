package Model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<CD> cdList;

    public List<CD> getCdList() {
        return cdList;
    }

    public void setCdList(List<CD> cdList) {
        this.cdList = cdList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "cdList=" + cdList.toString() +
                '}';
    }
}
