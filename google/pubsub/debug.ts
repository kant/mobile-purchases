import { handler } from "./pubsub";

let result = handler({queryStringParameters: {secret: "MYSECRET"}, body: "{\n" +
        "  \"version\":\"1.0\",\n" +
        "  \"packageName\":\"com.some.thing\",\n" +
        "  \"eventTimeMillis\":\"1503349566168\",\n" +
        "  \"subscriptionNotification\":\n" +
        "  {\n" +
        "    \"version\":\"1.0\",\n" +
        "    \"notificationType\":4,\n" +
        "    \"purchaseToken\":\"PURCHASE_TOKEN\",\n" +
        "    \"subscriptionId\":\"my.sku\"\n" +
        "  }\n" +
        "}\n" });

result.then(JSON.stringify).then(console.log);