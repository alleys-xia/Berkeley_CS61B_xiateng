public class NBody {
	public static double readRadius(String url) {
		In in= new In(url);
		in.readInt();
		double radius= in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String url) {
		In in= new In(url);
		int num= in.readInt();
		Planet[] p= new Planet[num];

		in.readDouble();
		for(int i=0;i<num;++i) {
			double xxPos= in.readDouble();
			double yyPos= in.readDouble();
			double xxVel= in.readDouble();
			double yyVel= in.readDouble();
			double mass=  in.readDouble();
			String imgFileName= in.readString();
			p[i]= new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return p;
	}

	public static void main(String[] args) {
		double T= Double.parseDouble(args[0]);
		double dt= Double.parseDouble(args[1]);
		String filename= args[2];
		Planet[] p= readPlanets(filename);
		double radius= readRadius(filename);
		int length= p.length;
		String background= "images/starfield.jpg";
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, background);
		for(int i=0;i<length;++i) {
			p[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		StdDraw.show();
		double time= 0.0;
		while(time<T) {
			double[] xForces= new double[5];
			double[] yForces= new double[5];
			for(int i=0;i<length;++i) {
				xForces[i]= p[i].calcNetForceExertedByX(p);
				yForces[i]= p[i].calcNetForceExertedByY(p);
			}
			for(int j=0;j<length;++j) {
				p[j].update(dt, xForces[j], yForces[j]);
			}
			StdDraw.picture(0, 0, background);
			for(int i=0;i<length;++i) {
				p[i].draw();
			}
			StdDraw.show();
			time+=dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
               	planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}