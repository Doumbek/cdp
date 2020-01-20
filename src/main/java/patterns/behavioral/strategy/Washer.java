package patterns.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

public class Washer {

    private final Map<Integer, IProgramType> programs = new HashMap<>();
    private IProgramType currentProgram;

     public Washer() {
         programs.put(1, new SilkProgram());
         programs.put(2, new CottonProgram());
     }

    public void setCurrentProgram(final Integer programIndex) {
        this.currentProgram = programs.get(programIndex);
    }

    public void wash() {
        currentProgram.wash();
    }

}

