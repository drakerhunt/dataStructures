class Circle extends GeometricObject {
	double radius;
	
	public Circle() {
		this.radius = 3;
		this.area = Math.PI * (this.radius * this.radius);
	}
	public Circle(double radius) {
		this.radius = radius;
		this.area = Math.PI * (this.radius * this.radius);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return this.radius;
	}
}