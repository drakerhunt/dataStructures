class Rectangle extends GeometricObject {
	double width, height;
	
	public Rectangle() {
		this.width = 5;
		this.height = 2;
		area = this.width * this.height;
	}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		this.area = width * height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
}