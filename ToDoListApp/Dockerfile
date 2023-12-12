FROM node:14 AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build -- --output-path=./dist

FROM node:14
WORKDIR /app
COPY --from=build /app/dist ./dist
RUN npm install -g @angular/cli serve dist http-server
EXPOSE 4200
CMD ["serve", "-s", "dist", "-l", "4200"]
