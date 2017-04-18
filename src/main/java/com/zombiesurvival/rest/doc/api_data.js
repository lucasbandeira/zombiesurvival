define({ "api": [
  {
    "type": "post",
    "url": "/survivor/:survivorId/inventory",
    "title": "Create a list of Inventories",
    "name": "CreateInventories",
    "group": "Inventory",
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "\t[\n    {\n      \"amount\": 1,\n      \"item\": : {\n      \t\"id\": \"WATER\"\n      },\n    },\n    {\n      \"amount\": 1,\n      \"item\": : {\n      \t\"id\": \"AMMUNITION\"\n      },\n    },\n    {\n      \"amount\": 2,\n      \"item\": : {\n      \t\"id\": \"MEDICATION\"\n      },\n    },\n    {\n      \"amount\": 0,\n      \"item\": : {\n      \t\"id\": \"FOOD\"\n      },\n    }\n ]",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 201 OK\n\tCreated a list of Inventories",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Inventory"
  },
  {
    "type": "post",
    "url": "/survivor",
    "title": "Create Survivor",
    "name": "CreateSurvivor",
    "group": "Survivor",
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"name\": \"Maria\",\n  \"age\": 30,\n  \"gender\": 0 , //0 female and 1 male\n  \"latitude\": \"-123696\",\n  \"longitude\": \"123686\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 201 OK\n\tSurvivor added",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Survivor"
  },
  {
    "type": "get",
    "url": "/rest/survivors",
    "title": "Request Survivors information",
    "name": "GetSurvivors",
    "group": "Survivor",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "id",
            "description": "<p>id of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "name",
            "description": "<p>name of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": true,
            "field": "age",
            "description": "<p>age of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "gender",
            "description": "<p>gender of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "latitude",
            "description": "<p>latitude of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "longitude",
            "description": "<p>longitude of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": true,
            "field": "delation",
            "description": "<p>delation count how many delation.</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": true,
            "field": "infected",
            "description": "<p>infected if is infected.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n  [\n\t  {\n\t    \"id\": 2,\n\t    \"name\": \"Maria\",\n\t    \"age\": 30,\n\t    \"gender\": \"FEMALE\",\n\t    \"latitude\": \"-123696\",\n\t    \"longitude\": \"123686\",\n\t    \"delation\": 0,\n\t    \"infected\": false\n\t  },\n\t  {\n\t    \"id\": 3,\n\t    \"name\": \"Mariana\",\n\t    \"age\": 20,\n\t    \"gender\": \"FEMALE\",\n\t    \"latitude\": \"-123696\",\n\t    \"longitude\": \"123686\",\n\t    \"delation\": 0,\n\t    \"infected\": false\n\t  },\n\t  {\n\t    \"id\": 1,\n\t    \"name\": \"Lucas\",\n\t    \"age\": 25,\n\t    \"gender\": \"MALE\",\n\t    \"latitude\": \"-123696\",\n\t    \"longitude\": \"125686\",\n\t    \"delation\": 0,\n\t    \"infected\": false\n\t  }\n\t]",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Survivor"
  },
  {
    "type": "get",
    "url": "/survivors/:name",
    "title": "Request Survivors information",
    "name": "GetSurvivorsByName",
    "group": "Survivor",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "name",
            "optional": false,
            "field": "name",
            "description": "<p>of the Survivor.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "id",
            "description": "<p>id of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "name",
            "description": "<p>name of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": true,
            "field": "age",
            "description": "<p>age of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "gender",
            "description": "<p>gender of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "latitude",
            "description": "<p>latitude of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "longitude",
            "description": "<p>longitude of the Survivor.</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": true,
            "field": "delation",
            "description": "<p>delation count how many delation.</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": true,
            "field": "infected",
            "description": "<p>infected if is infected.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "    HTTP/1.1 200 OK\n\t\t[\n\t\t  {\n\t\t    \"id\": 2,\n\t\t    \"name\": \"Maria\",\n\t\t    \"age\": 30,\n\t\t    \"gender\": \"FEMALE\",\n\t\t    \"latitude\": \"-123696\",\n\t\t    \"longitude\": \"123686\",\n\t\t    \"delation\": 0,\n\t\t    \"infected\": false\n\t\t  },\n\t\t  {\n\t\t    \"id\": 3,\n\t\t    \"name\": \"Mariana\",\n\t\t    \"age\": 20,\n\t\t    \"gender\": \"FEMALE\",\n\t\t    \"latitude\": \"-123696\",\n\t\t    \"longitude\": \"123686\",\n\t\t    \"delation\": 0,\n\t\t    \"infected\": false\n\t\t  }\n\t\t]",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Survivor"
  },
  {
    "type": "get",
    "url": "/report-percent/:category",
    "title": "Show report",
    "name": "Report",
    "group": "Survivor",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "category",
            "optional": false,
            "field": "category",
            "description": "<p>of the Report. 0 - Percent Infected or 1 - Percent of not infected</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n\tPercentage of infected is :value\n or\n Percentage of not infected is :value",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Survivor"
  },
  {
    "type": "put",
    "url": "/survivor/:survivorId",
    "title": "Update a Survivor.",
    "name": "UpdateSurvivor",
    "group": "Survivor",
    "parameter": {
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n  \"latitude\": \"14235325\",\n  \"longitude\": \"4354543\"\n}\n\nor\n\n{\n  \"infected\": true\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n\tSurvivor updated",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./ZombieSurvivalREST.java",
    "groupTitle": "Survivor"
  }
] });
