package pl.dlsoftware.cdk;

import pl.dlsoftware.cdk.CdkStack;
import software.amazon.awscdk.App;
import software.amazon.awscdk.assertions.Template;

import java.io.IOException;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class CdkStackTest {

    @Test
    public void testStack() throws IOException {
        App app = new App();
        CdkStack stack = new CdkStack(app, "test");

        Template template = Template.fromStack(stack);

        template.hasResourceProperties("AWS::SQS::Queue", new HashMap<String, Number>() {{
          put("VisibilityTimeout", 300);
        }});

        template.resourceCountIs("AWS::SNS::Topic", 1);
    }
}
