package armansoft.beanconverter;
     //09105147087->r.mazloom
import armansoft.beanconverter.parsers.BeanUtil;
import armansoft.beanconverter.parsers.SampleBean;
//import com.stellent.cis.common.bean.BeanUtil ;
/**
 * Created with IntelliJ IDEA.
 * User: rmazloom
 * Date: 2/7/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(1);
        BeanUtil.toString(new SampleBean());
        System.out.println(BeanUtil.toString(new SampleBean()));
    }

}
