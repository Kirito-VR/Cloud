import com.mongodb.client.MongoCollection;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.bson.Document;
import org.example.mongoDB.util.MongoUtil;

import java.util.HashMap;
import java.util.List;

public class AppTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {


        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("id","1234");
        map.put("m",map2);
        map.put("deviceId","1002");
        Document d = MongoUtil.transMap2Document(map);
        System.out.println("最后的文档结构"+d);
        MongoCollection<Document> collection = MongoUtil.getCollection("collect1");
        List<String> list = MongoUtil.getResult2List(collection,d);

        System.out.println(list);


    }
}
