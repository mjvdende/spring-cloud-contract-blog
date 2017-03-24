

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'GET'
        url value(consumer(regex('/account/[0-9]{5}')), producer('/account/22222'))
    }

    response {
        status 200
        body([
                type: 'regular',
                email: 'jack@api.io'
        ])
        headers {
            header('Content-Type': value(
                    producer(regex('application/json.*')),
                    consumer('application/json')
            ))
        }
    }
}
