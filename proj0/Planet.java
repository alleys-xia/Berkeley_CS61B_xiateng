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
		if(dx<0) {
			dx= -dx;
		}
		if(dy<0) {
			dy= -dy;
		}
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

	
}