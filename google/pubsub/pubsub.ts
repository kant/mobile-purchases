import {HTTPRequest, HTTPResponse, HTTPHeaders, HTTPResponses} from "./models/apiGatewayHttp";
import {DeveloperNotification} from "./models/developerNotification";

const secret = process.env.Secret;

export async function handler(request: HTTPRequest): Promise<HTTPResponse> {
    try {
        let notification = JSON.parse(request.body) as DeveloperNotification;
        console.log(notification)
    } catch (e) {
        console.error("Unable to parse JSON", e);
    }
    if (request.queryStringParameters.secret === secret) {
        return HTTPResponses.OK
    } else {
        return HTTPResponses.UNAUTHORISED
    }
}


