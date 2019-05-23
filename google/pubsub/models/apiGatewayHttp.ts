export interface QueryParameters {
    [key: string]: string
}

export interface HTTPRequest {
    body: string
    queryStringParameters: QueryParameters
}

export class HTTPHeaders {
    "Content-Type": string = "application/json";
    constructor() {}
}

export class HTTPResponse {
    statusCode: number;
    headers: HTTPHeaders;
    body: string;

    constructor(statusCode: number, headers: HTTPHeaders, body: string) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }
}

export const HTTPResponses = {
    OK: new HTTPResponse(200, new HTTPHeaders(), "{\"status\": 200, \"message\": \"OK\"}"),
    UNAUTHORISED: new HTTPResponse(200, new HTTPHeaders(), "{\"status\": 401, \"message\": \"UNAUTHORISED\"}"),
    INTERNAL_ERROR: new HTTPResponse(200, new HTTPHeaders(), "{\"status\": 500, \"message\": \"INTERNAL SERVER ERROR\"}")
};