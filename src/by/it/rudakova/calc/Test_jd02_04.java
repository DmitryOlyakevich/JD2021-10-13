package by.it.rudakova.calc;

import by.it.rudakova.calc.VarRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test_jd02_04 {

    private static final double DELTA =1e-10;
    private Parser parser;
    @Before
    public void init(){
        VarRepository varRepository=new VarRepository();
        parser=new Parser(varRepository);
    }
    @Test(timeout = 5000)
    public void  scalarAddition() throws Exception{
        String expression="-2+-2*2-4+12";
        Var actualVar=parser.calc(expression);
        double actual=Double.parseDouble(actualVar.toString());
        double expected=2;
        assertEquals(expected,actual,DELTA);
    }

    @Test(timeout = 5000)
    public void  scalarAdditionWithOneVar() throws Exception{
        String expression="A=2+5.3";
        Var actualVar=parser.calc(expression);
        double actual=Double.parseDouble(actualVar.toString());
        double expected=7.3;
        assertEquals(expected,actual,DELTA);
    }
}
