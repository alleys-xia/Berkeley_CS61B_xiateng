public class Planet {
	public double xxPos;//current x position
	public double yyPos;//current y position
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public final double gConstant= 6.67e-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos= xP;
		yyPos= yP;
		xxVel= xV;
		yyVel= yV;
		mass= m;
		imgFileName= img;
	}

	public Planet(Planet a) {
		this.xxPos= a.xxPos;
		this.yyPos= a.yyPos;
		this.xxVel= a.xxVel;
		this.yyVel= a.yyVel;
		this.mass= a.mass;
		this.imgFileName= a.imgFileName;
	}

	public double calcDistance(Planet a) {
		double dx;
		double dy;
		double r;
		dx= this.xxPos-a.xxPos;
		dy= this.yyPos-a.yyPos;
		r= dx*dx+dy*dy;		
		return Math.sqrt(r);
	}


	public double calcForceExertedBy(Planet a) {
		double upper= gConstant*a.mass*this.mass;
		double dis= calcDistance(a);
		double force= upper/(dis*dis);
		return force;
	}

	public double calcForceExertedByX(Planet a) {
		double force= calcForceExertedBy(a);
		double dis= calcDistance(a);
		double fx= force*(a.xxPos-this.xxPos)/dis;
		return fx;
	}

	public double calcForceExertedByY(Planet a) {
		double force= calcForceExertedBy(a);
		double dis= calcDistance(a);
		double fy= force*(a.yyPos-this.yyPos)/dis;
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] arr) {
		int length= arr.length;
		double fx=0;
		for(int i=0;i<length;++i) {
			if(!this.equals(arr[i])){
				fx+=calcForceExertedByX(arr[i]);
			}
		}
			return fx;
	}

	public double calcNetForceExertedByY(Planet[] arr) {
		int length= arr.length;
		double fy=0;
		for(int i=0;i<length;++i) {
			if(!this.equals(arr[i])) {
				fy+=calcForceExertedByY(arr[i]);
			}
		}
			return fy;
	}

	public void update(double dt, double fx, double fy) {
		double ax= fx/mass;
		double ay= fy/mass;
		xxVel+= ax*dt;
		yyVel+= ay*dt;
		xxPos+= xxVel*dt;
		yyPos+= yyVel*dt;
	}

	public void draw() {
		String imgPath= "images/"+imgFileName;
		StdDraw.picture(xxPos, yyPos, imgPath);
	}
}