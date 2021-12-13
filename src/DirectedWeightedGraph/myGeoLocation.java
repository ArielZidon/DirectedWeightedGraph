package DirectedWeightedGraph;

import api.GeoLocation;

public class myGeoLocation implements GeoLocation {
    double x;
    double y;
    double z;


    public myGeoLocation(String Loc) {
        String[] str = Loc.split(",");
        this.x = Double.parseDouble(str[0]);
        this.y = Double.parseDouble(str[1]);
        this.z = Double.parseDouble(str[2]);
    }

    public myGeoLocation(GeoLocation n){
        this.x=n.x();
        this.y=n.y();
        this.z=n.z();
    }


    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        return Math.sqrt(Math.pow(this.x - g.x(), 2) + Math.pow(this.y - g.y(), 2) + Math.pow(this.z - g.z(), 2));
    }

    @Override
    public String toString() {
        return "DirectedWeightedGraph.myGeoLocation{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
