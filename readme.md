http://localhost:8080/orders/1020300001 - GET

Response:
{
    "idPedido": 1020300001,
    "email": "contato2@fiap.com.br",
    "nomeCompleto": "Contato Doisa da Silva",
    "shippingAddress": "Rua das Arartas, 281 - São Paulo",
    "formaPagamento": "CREDITO",
    "dataPedido": "2019-03-23T00:00:00.000+0000",
    "statusPedido": "EM ANDAMENTO",
    "itens": [
        {
            "nome": "Lanche",
            "descricao": "lanche legal",
            "valor": 10
        }
    ],
    "valorPedido": 10,
    "pagamento": {
        "idTransacao": 10213202,
        "numeroCartao": "5896125478544517",
        "validadeCartao": "2019-03-23T00:00:00.000+0000",
        "bandeira": "Visa"
    }
}
=============================================================================================================
http://localhost:8080/orders - POST

Body Request:
{
    "idPedido": 1020300001,
    "email": "contato2@fiap.com.br",
    "nomeCompleto": "Contato Doisa da Silva",
    "shippingAddress": "Rua das Arartas, 281 - São Paulo",
    "formaPagamento": "CREDITO",
    "dataPedido": "2019-03-23",
    "statusPedido": "EM ANDAMENTO",
    "itens": [
        {
            "nome": "Lanche",
            "descricao": "lanche legal",
            "valor": 10
        }
    ],
    "valorPedido": 10,
    "pagamento": {
        "idTransacao": 10213202,
        "numeroCartao": "5896125478544517",
        "validadeCartao": "2019-03-23",
        "bandeira": "Visa"
    }
}

Response:
{
    "success": true,
    "message": {
        "severity": "info",
        "summary": "Authenticated successfully.",
        "code": 200,
        "location": "/",
        "href": "http://localhost:8080/orders/1020300001"
    }
}
==============================================================================================================
http://localhost:8080/orders/1020300001 - PUT

Body Request:
{
    "idPedido": 1020300001,
    "email": "contato3@fiap.com.br",
    "nomeCompleto": "Contato Tres da da Silva",
    "shippingAddress": "Rua das Arartas, 281 - São Paulo",
    "formaPagamento": "CREDITO",
    "dataPedido": "2019-03-23",
    "statusPedido": "EM ANDAMENTO",
    "itens": [
        {
            "nome": "Lanche",
            "descricao": "lanche legal",
            "valor": 10
        }
    ],
    "valorPedido": 10,
    "pagamento": {
        "idTransacao": 10213202,
        "numeroCartao": "5896125478544517",
        "validadeCartao": "2019-03-23",
        "bandeira": "Visa"
    }
}

============================================================================================================
http://localhost:8080/orders/1020300001 - DELETE