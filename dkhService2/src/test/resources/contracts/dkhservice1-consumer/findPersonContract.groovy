import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return Person when path param is PersonId"
    request {
        method 'GET'
        urlPath('/person/1')
    }
    response {
        status OK()
        body([
            name: 'Juan',
            surname: 'Rodriguez'
        ])
        headers {
            contentType(applicationJson())
        }
    }
}