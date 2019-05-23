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