#1: Build the app
FROM node:10.16-alpine AS builder

WORKDIR /usr/src/app
COPY . .
#RUN npm ci && npm run build

#2: Use nginx
FROM nginx:stable-alpine
LABEL version="1.0"

COPY nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html
COPY --from=builder /usr/src/app/dist/banco-frontend/ .
