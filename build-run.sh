#!/bin/bash

# Hospital Billing Backend - Build and Run Script
# Usage: ./build-run.sh [OPTIONS]
#
# OPTIONS:
#   --skip-clean      Skip mvn clean
#   --skip-tests      Skip running tests
#   --skip-build      Skip build step (only run application)
#   --docker          Build and run using Docker
#   --prod            Use production profile instead of dev
#   --port PORT       Specify custom port (default: 8080)
#   -h, --help        Show this help message

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Default flags
SKIP_CLEAN=false
SKIP_TESTS=false
SKIP_BUILD=false
USE_DOCKER=false
PROFILE="dev"
PORT="8080"

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        --skip-clean)
            SKIP_CLEAN=true
            shift
            ;;
        --skip-tests)
            SKIP_TESTS=true
            shift
            ;;
        --skip-build)
            SKIP_BUILD=true
            shift
            ;;
        --docker)
            USE_DOCKER=true
            shift
            ;;
        --prod)
            PROFILE="prod"
            shift
            ;;
        --port)
            PORT="$2"
            shift 2
            ;;
        -h|--help)
            echo "Hospital Billing Backend - Build and Run Script"
            echo ""
            echo "Usage: ./build-run.sh [OPTIONS]"
            echo ""
            echo "OPTIONS:"
            echo "  --skip-clean      Skip mvn clean"
            echo "  --skip-tests      Skip running tests"
            echo "  --skip-build      Skip build step (only run application)"
            echo "  --docker          Build and run using Docker"
            echo "  --prod            Use production profile instead of dev"
            echo "  --port PORT       Specify custom port (default: 8080)"
            echo "  -h, --help        Show this help message"
            exit 0
            ;;
        *)
            echo -e "${RED}Unknown option: $1${NC}"
            echo "Use --help for usage information"
            exit 1
            ;;
    esac
done

# Docker build and run
if [ "$USE_DOCKER" = true ]; then
    echo -e "${GREEN}Building and running with Docker...${NC}"

    echo -e "${YELLOW}Building Docker image...${NC}"
    docker build -t hospital-billing-backend .

    if [ $? -eq 0 ]; then
        echo -e "${GREEN}Docker image built successfully${NC}"
        echo -e "${YELLOW}Running Docker container...${NC}"
        docker run -d -p ${PORT}:8080 \
            -e SPRING_PROFILES_ACTIVE=${PROFILE} \
            --name hospital-billing-backend \
            hospital-billing-backend

        if [ $? -eq 0 ]; then
            echo -e "${GREEN}Backend is running at http://localhost:${PORT}${NC}"
            echo -e "${YELLOW}API available at http://localhost:${PORT}/api${NC}"
            if [ "$PROFILE" = "dev" ]; then
                echo -e "${YELLOW}H2 Console available at http://localhost:${PORT}/h2-console${NC}"
            fi
        else
            echo -e "${RED}Failed to start Docker container${NC}"
            exit 1
        fi
    else
        echo -e "${RED}Docker build failed${NC}"
        exit 1
    fi
    exit 0
fi

# Build Maven project
BUILD_CMD="mvn"

if [ "$SKIP_CLEAN" = false ]; then
    BUILD_CMD="$BUILD_CMD clean"
fi

if [ "$SKIP_BUILD" = false ]; then
    BUILD_CMD="$BUILD_CMD compile"

    # Run tests if not skipped
    if [ "$SKIP_TESTS" = false ]; then
        echo -e "${YELLOW}Running tests...${NC}"
        mvn test

        if [ $? -ne 0 ]; then
            echo -e "${RED}Tests failed${NC}"
            exit 1
        fi
        echo -e "${GREEN}Tests passed successfully${NC}"
    else
        echo -e "${YELLOW}Skipping tests${NC}"
    fi

    echo -e "${YELLOW}Building application...${NC}"
    eval $BUILD_CMD

    if [ $? -ne 0 ]; then
        echo -e "${RED}Build failed${NC}"
        exit 1
    fi
    echo -e "${GREEN}Build completed successfully${NC}"
else
    echo -e "${YELLOW}Skipping build step${NC}"
fi

# Run the application
echo -e "${YELLOW}Starting Spring Boot application...${NC}"
echo -e "${YELLOW}Profile: ${PROFILE}${NC}"
echo -e "${YELLOW}Port: ${PORT}${NC}"

RUN_CMD="mvn spring-boot:run -Dspring-boot.run.profiles=${PROFILE} -Dspring-boot.run.jvmArguments=\"-Dserver.port=${PORT}\""

if [ "$SKIP_TESTS" = true ]; then
    RUN_CMD="$RUN_CMD -DskipTests"
fi

echo -e "${GREEN}Starting application...${NC}"
eval $RUN_CMD
