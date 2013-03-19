@Grab('org.apache.camel:camel-core:2.10.0')
@Grab('org.slf4j:slf4j-simple:1.6.6')
import org.apache.camel.*
import org.apache.camel.impl.*
import org.apache.camel.builder.*

def camelContext = new DefaultCamelContext()
camelContext.addRoutes(new RouteBuilder() {
    def void configure() {
          from("file:/home/rick/Junk?noop=true&include=.//*.cml")
             .to("log://camelLogger?level=INFO")
    }
})
camelContext.start()

addShutdownHook{ camelContext.stop() }
synchronized(this){ this.wait() }
