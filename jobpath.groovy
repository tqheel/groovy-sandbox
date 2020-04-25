#!groovy

private List<String> resolveSubJobNames(Enum jobTypeToCall, Enum originatingJobType) {
    switch (originatingJobType) {
        case PeerJobType.WRAPPER:
            switch (jobTypeToCall) {
                case PeerJobType.PEER_TWISTLOCK_BUILD: 
                    return []
                case PeerJobType.PEER_FULL_STACK:
                    return ["full-peer-stack-controller"]
                case PeerJobType.CDN:
                    return ["Publish_JavaScript","Invalidate-CloudFront-Cache"]
                case PeerJobType.OPS_DEV_ECR_STACK_CONTROLLER:
                    return []
                case PeerJobType.ECR_STACK_CONTROLLER:
                    return ['']
                case PeerJobType.UPDATE_FARGATE_CLUSTER:
                    return ["update-fargate-cluster"]
                case PeerJobType.UPDATE_FARGATE_SERVICE:
                    return ["update-fargate-service"]
                case PeerJobType.FARGATE_CLUSTER_STACK_CONTROLLER:
                    return []
                case PeerJobType.FARGATE_SERVICE_STACK_CONTROLLER:
                    return []
                case PeerJobType.DATABASE_STACK:
                    return []
                case PeerJobType.DATABASE_SCHEMA:
                    return []

                default: return []
            }
        default: return []
    }
}

List<String> resolveFullJobToCallPath(Enum jobTypeToCall, Enum originatingJobType, String envType) {
    // def currentJobName = ${env.JOB_NAME}

    switch (envType) {
        
    }
    
}

enum PeerJobType {
    WRAPPER,
    PEER_TWISTLOCK_BUILD,
    PEER_FULL_STACK,    
    CDN,
    OPS_DEV_ECR_STACK_CONTROLLER,
    ECR_STACK_CONTROLLER,
    UPDATE_FARGATE_CLUSTER,
    UPDATE_FARGATE_SERVICE,
    FARGATE_CLUSTER_STACK_CONTROLLER,
    FARGATE_SERVICE_STACK_CONTROLLER,
    DATABASE_STACK,
    DATABASE_SCHEMA
}

println(PeerJobType.values())

println(PeerJobType.valueOf("CDN").ordinal())

println("values are equal: ${PeerJobType.CDN == 'CDN' as PeerJobType}")

try {
    println(resolveSubJobNames("nuthin" as PeerJobType, "sumpin" as PeerJobType))
}
catch (ex) {
    println(ex.getMessage())
}

println(resolveSubJobNames(PeerJobType.PEER_FULL_STACK, PeerJobType.WRAPPER))

println(resolveSubJobNames(PeerJobType.UPDATE_FARGATE_CLUSTER, PeerJobType.WRAPPER))
def jobResult = resolveSubJobNames(PeerJobType.DATABASE_SCHEMA, PeerJobType.WRAPPER)

if (!jobResult) {
    println('Job type not currently supported.')
}
else {
    println("Sub Job is: ${jobResult}")
}
