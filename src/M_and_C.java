import java.util.ArrayList;

/**
 * Created by student on 10/26/2017.
 */
public class M_and_C {
    public int ml, cl, mr, cr;
    String b;

    public M_and_C(int ml, int cl, int mr, int cr, String b) {
        this.ml = ml;
        this.cl = cl;
        this.mr = mr;
        this.cr = cr;
        this.b = b;
    }

    public M_and_C (M_and_C my){
        this.ml = my.ml;
        this.cl = my.cl;
        this.mr = my.mr;
        this.cr = my.cr;
        this.b = my.b;
    }
    public String toString() {
        return "( " + ml + ", " + cl + ", " + mr + ", " + cr + ", " + b + " )";
    }


    public boolean isValid() {
        if(ml >= 0 && cl >= 0 && mr >= 0 && cr >= 0 && (ml == 0 || ml >= cl) && (mr == 0 || mr >= cr)) {
            return true;
        }
        return false;
    }


    /*
    * Goal State
    */
    public Boolean isGoalState(){
        if(ml == 0 && cl == 0)
            return true;
        return false;
    }

    /*Apply Action*/
    public ArrayList<M_and_C> ApplyAction(){
        ArrayList<M_and_C> success = new ArrayList<>();

        /*Action One*/
        M_and_C s;
        if(b.equals("LEFT")){
            s = new M_and_C(ml-1, cl, mr+1,cr, "RIGHT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml-2, cl, mr+2,cr, "RIGHT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml, cl-1, mr,cr+1, "RIGHT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml, cl-2, mr,cr+2, "RIGHT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml-1, cl-1, mr+1,cr+1, "RIGHT");
            if(s.isValid()){
                success.add(s);
            }
        }else {
            s = new M_and_C(ml+1, cl, mr-1,cr, "LEFT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml+2, cl, mr-2,cr, "LEFT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml, cl+1, mr,cr-1, "LEFT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml, cl+2, mr,cr-2, "LEFT");
            if(s.isValid()){
                success.add(s);
            }
            s = new M_and_C(ml+1, cl+1, mr-1,cr-1, "LEFT");
            if(s.isValid()){
                success.add(s);
            }
        }

        return  success;
    }

}
