import boto3
import os

# Refer to the Boto3 documentation:
#    http://boto3.readthedocs.io/en/latest/guide/quickstart.html
#
# Your AWS credentials must be configured in accordance with:
#    http://boto3.readthedocs.io/en/latest/guide/configuration.html

IMAGE_ID = 'ami-cd0f5cb6'
INSTANCE_TYPE = 't2.micro'
KEY_NAME = 'cc_15619_test'
SECURITY_GROUP = 'cc_15619'
ACCESS_KEY = os.environ['AWS_ACCESS_KEY_ID']
SECRET_KEY = os.environ['AWS_SECRET_KEY']


# Create an EC2 Client
ec2_client = boto3.client("ec2",
                          region_name="us-east-1",
                          aws_access_key_id=ACCESS_KEY,
                          aws_secret_access_key=SECRET_KEY)

# Launching instance
#
# http://boto3.readthedocs.io/en/latest/reference/services/ec2.html#EC2.Client.run_instances
response = ec2_client.run_instances(
    ImageId=IMAGE_ID,
    InstanceType=INSTANCE_TYPE,
    KeyName=KEY_NAME,
    MaxCount=1,
    MinCount=1,
    SecurityGroups=[
        SECURITY_GROUP,
    ]
)

instance = response.get('Instances')[0]

print("Launched instance with Instance Id: [{}]!".format(instance.get('InstanceId')))
