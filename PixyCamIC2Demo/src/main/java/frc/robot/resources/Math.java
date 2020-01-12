package frc.robot.resources;

public class Math {
    public static double clamp(double mn, double mx, double x){
        return java.lang.Math.max(java.lang.Math.min(mx,x),mn);
    }
}
