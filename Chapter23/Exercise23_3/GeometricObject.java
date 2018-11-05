import java.util.*;

class GeometricObject {
	double area;
	
	public GeometricObject(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return this.area;
	}
}

class GeometricObjectComparator implements Comparator<GeometricObject> {
	
	@Override
	public int compare(GeometricObject o1, GeometricObject o2) {
		if (o1.getArea() > o2.getArea()) 
			return 1;
		else if (o1.getArea() < o2.getArea()) 
			return -1;
		else 
			return 0;
	}
}