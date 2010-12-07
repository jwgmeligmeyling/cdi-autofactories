package pl.softwaremill.common.sdb.backup;

import com.xerox.amazonws.simpledb.Domain;
import com.xerox.amazonws.simpledb.Item;
import com.xerox.amazonws.simpledb.SDBException;
import com.xerox.amazonws.simpledb.SimpleDB;
import org.testng.annotations.BeforeClass;
import pl.softwaremill.common.conf.Configuration;

import java.util.Map;
import java.util.Set;

import static org.fest.assertions.Assertions.*;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public abstract class AbstractBackupAndRestoreTest {
    public static final String AWS_ACCESS_KEY_ID = Configuration.get("backuptest").get("AWSAccessKeyId");
    public static final String AWS_SECRET_ACCESS_KEY = Configuration.get("backuptest").get("SecretAccessKey");

    protected SimpleDB simpleDB;

    @BeforeClass
    public void prepareSimpleDB() throws SDBException {
        simpleDB = new SimpleDB(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY, true, SimpleDBRegion.US_WEST.getAddress());
    }

    protected void clearDomain(Domain domain) throws SDBException {
        simpleDB.deleteDomain(domain);
        simpleDB.createDomain(domain.getName());
        makeConsistent(domain);
    }

    protected void populateDomainWithData(Domain domain, Map<String, Map<String, Set<String>>> data) throws SDBException {
        for (Map.Entry<String, Map<String, Set<String>>> dataEntry : data.entrySet()) {
            Item item = domain.createItem(dataEntry.getKey());
            item.getAttributes().putAll(dataEntry.getValue());
            domain.addItem(item);
        }

        makeConsistent(domain);
    }

    protected void assertDomainHasData(Domain domain, Map<String, Map<String, Set<String>>> data) throws SDBException {
        makeConsistent(domain);
        
        for (Map.Entry<String, Map<String, Set<String>>> dataEntry : data.entrySet()) {
            Item item = domain.getItem(dataEntry.getKey(), true).getResult();
            assertThat(item).isNotNull();

            for (Map.Entry<String, Set<String>> attributeDataEntry : dataEntry.getValue().entrySet()) {
                Set<String> attributeDataValues = item.getAttributeValues(attributeDataEntry.getKey());
                assertThat(attributeDataValues.containsAll(attributeDataEntry.getValue())).isTrue();
            }
        }
    }

    protected void makeConsistent(Domain domain) throws SDBException {
        domain.getItem("anything", true);
    }
}
