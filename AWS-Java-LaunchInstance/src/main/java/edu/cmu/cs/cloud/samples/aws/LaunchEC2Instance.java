package edu.cmu.cs.cloud.samples.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

public class LaunchEC2Instance {
    private static final String AMI_ID         = "ami-cd0f5cb6";
    private static final String INSTANCE_TYPE  = "t2.micro";
    private static final String KEY_NAME       = "cc_15619_test";
    private static final String SECURITY_GROUP = "cc_15619";

    public static void main(String[] args) {
        /*
         * http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/auth/DefaultAWSCredentialsProviderChain.html
         *
         * AWS credentials provider chain that looks for credentials in this order:
         *   1. Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY
         *   2. Java System Properties - aws.accessKeyId and aws.secretKey
         *   3. Credential profiles file at the default location (~/.aws/credentials) shared by all AWS SDKs and the AWS CLI
         *   4. Credentials delivered through the Amazon EC2 container service if AWS_CONTAINER_CREDENTIALS_RELATIVE_URI"
         *       environment variable is set and security manager has permission to access the variable
         *   5. Instance profile credentials delivered through the Amazon EC2 metadata service
         */
        AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();

        // Create an Amazon EC2 Client
        AmazonEC2 ec2 = AmazonEC2ClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.US_EAST_1)
                .build();

        // Create a Run Instance Request
        RunInstancesRequest runInstancesRequest = new RunInstancesRequest()
                .withImageId(AMI_ID)
                .withInstanceType(INSTANCE_TYPE)
                .withMinCount(1)
                .withMaxCount(1)
                .withKeyName(KEY_NAME)
                .withSecurityGroups(SECURITY_GROUP);

        // Execute the Run Instance Request
        RunInstancesResult runInstancesResult = ec2.runInstances(runInstancesRequest);

        // Return the Object Reference of the Instance just Launched
        Instance instance = runInstancesResult.getReservation()
                .getInstances()
                .get(0);

        System.out.printf("Launched instance with Instance Id: [%s]!\n", instance.getInstanceId());

        ec2.shutdown();
    }
}
