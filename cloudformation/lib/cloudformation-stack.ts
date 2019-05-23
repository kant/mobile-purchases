import cdk = require('@aws-cdk/cdk');
import apiGateway = require('@aws-cdk/aws-apigateway');

export class CloudformationStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    /*let stack = new cdk.CfnParameter(this, "Stack", {
      type: "String",
      description: "Stack name"
    });*/

    let app = new cdk.CfnParameter(this, "App", {
      type: "String",
      description: "Application name"
    });

    let stage = new cdk.CfnParameter(this, "Stage", {
      type: "String",
      description: "Stage name",
      allowedValues: ["CODE", "PROD"]
    });

    let apiCertArn = new cdk.CfnParameter(this, "ApiCertArn", {
      type: "String",
      description: "ACM Certificate for api use"
    });

    let hostedZoneName = new cdk.CfnParameter(this, "HostedZoneName", {
      type: "String",
      description: "HostedZoneName"
    });

    let mobilePurchasesApi = new apiGateway.CfnRestApi(this, "MobilePuchasesApi", {
      body: {
        info: {
          version: "1.0.0",
          title: app.value + '-' + stage.value
        }
      }
    });


    new apiGateway.CfnDeployment(this, "MobilePuchasesApiDeploymentc9a35abc81", {
      restApiId: mobilePurchasesApi.ref,
      description: "RestApi deployment id: c9a35abc8119d7c577a94895f265b550815ad3ff",
      stageName: "Stage"
    });

    new apiGateway.CfnDomainName(this, "ApiDomainName", {
      certificateArn: apiCertArn.ref,
      domainName: app.value + '.' + hostedZoneName.value
    })
  }
}
