import {HTTPRequest, HTTPResponse, HTTPHeaders} from "./models/apiGatewayHttp";

const secret = process.env.Secret;

export async function handler(request: HTTPRequest): Promise<HTTPResponse> {
    if (request.queryStringParameters.secret === secret) {
        return new HTTPResponse(200, new HTTPHeaders(), "OK")
    } else {
        return new HTTPResponse(500, new HTTPHeaders(), "Server Error")
    }
}


