# IIS_Projekt_Bestellung_per_Drohne


## Nachrichten an Camunda

```
{
  "messageName" : "orderReceivedMessage",
  "correlationKeys" : {
    "orderId" : {
      "type" : "Integer",
      "value" : ""
    }
  }
}
```

```
{
  "messageName" : "invoicePaidMessage",
  "correlationKeys" : {
    "orderId" : {
      "type" : "Integer",
      "value" : ""
    }
  }
}
```
