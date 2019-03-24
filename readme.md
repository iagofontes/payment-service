http://localhost:8080/findById/12541201203 - GET

Response:
{
    "idTransacao": 12541201203,
    "numeroCartao": "5179454051048026",
    "validadeCartao": "03/2021",
    "valorCompra": 550.1,
    "bandeiraCartao": "MasterCard"
}
=============================================================================================================
http://localhost:8080/save - POST

Body Request:
{
    "idTransacao": 12541201203,
    "numeroCartao": "5179454051048026",
    "validadeCartao": "03/2021",
    "valorCompra": "550.10",
    "bandeiraCartao": "MasterCard"
}

Response:
{
    "success": true,
    "message": {
        "severity": "info",
        "summary": "Created successfully.",
        "code": 201,
        "location": "http://localhost:8080/findById/12541201203"
    }
}
==============================================================================================================
http://localhost:8080/update/12541201203 - PUT

Body Request:
{
    "idTransacao": 12541201203,
    "numeroCartao": "5179454051048026",
    "validadeCartao": "03/2021",
    "valorCompra": "530.10",
    "bandeiraCartao": "Visa"
}

Response:
{
    "success": true,
    "message": {
        "severity": "info",
        "summary": "Updated successfully.",
        "code": 200,
        "location": "http://localhost:8080/findById/12541201203"
    }
}

=============================================================================================================
http://localhost:8080/delete/12541201203 - DELETE

Response:
{
    "success": true,
    "message": {
        "severity": "info",
        "summary": "Removed successfully.",
        "code": 200
    }
}