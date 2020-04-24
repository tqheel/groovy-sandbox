#!groovy

def resolveSubJobName(Enum jobTypeToCall, Enum currentJobType) {
    switch (currentJobType) {
        case PeerJobTypeEnum.WRAPPER:
            switch (jobTypeToCall) {
                case PeerJobTypeEnum.PEER_FULL_STACK:
                    return "full-peer-stack-controller"
                case PeerJobTypeEnum.
                default: return "not the full peer stack"
            }
        default: return "not the wrapper"
    }
}

def resolveFullJobToCallPath(Enum jobTypeToCall, Enum currentJobType, String envType) {
    // def currentJobName = ${env.JOB_NAME}

    switch (jobTypeToCall) {
        case ~/.*create_ECR.*/:
        case ~/.*ecr-stack-controller.*/:
            println("run ecr job")

        case ~/.*create_fargate_cluster.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
        
        case ~/.*.*/:
        case ~/.*.*/:
                
        default:
            error("Could not resolve Peer job type.")
    }
    def jobToCall = ""
    def jobPathToCall = ""
    
}

enum PeerJobTypeEnum {
    WRAPPER,
    PEER_FULL_STACK,    
    CDN,
    UPDATE_FARGATE_CLUSTER,
    UPDATE_FARGATE_SERVICE,
    DATABASE_STACK,
    DATABASE_SCHEMA
}

println(PeerJobTypeEnum.values())

println(PeerJobTypeEnum.valueOf("CDN").ordinal())

println("values are equal: ${PeerJobTypeEnum.CDN == 'CDN' as PeerJobTypeEnum}")

try {
    println(resolveSubJobName("nuthin" as PeerJobTypeEnum, "sumpin" as PeerJobTypeEnum))
}
catch (ex) {
    println(ex.getMessage())
}

println(resolveSubJobName(PeerJobTypeEnum.PEER_FULL_STACK, PeerJobTypeEnum.WRAPPER))

println(resolveSubJobName(PeerJobTypeEnum.UPDATE_FARGATE_CLUSTER, PeerJobTypeEnum.WRAPPER))

println(resolveSubJobName(PeerJobTypeEnum.PEER_FULL_STACK, PeerJobTypeEnum.UPDATE_FARGATE_CLUSTER))