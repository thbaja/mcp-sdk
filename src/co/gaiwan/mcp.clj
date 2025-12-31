(ns co.gaiwan.mcp
  "mcp-sdk main entry points"
  (:require
   [co.gaiwan.mcp.system.http :as http]
   [co.gaiwan.mcp.system.stdio :as stdio]
   [co.gaiwan.mcp.system.watch-state :as watch]))

(defn run-http!
  "Run HTTP/SSE based MCP server"
  [opts]
  (let [server (http/start! opts)]
    (watch/start! opts)
    server))

(defn stop-http!
  [server]
  (http/stop! server))

(defn run-stdio!
  "Run STDIO based MCP server"
  [opts]
  (stdio/start! opts)
  (watch/start! opts))
