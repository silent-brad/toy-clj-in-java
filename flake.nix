{
  description = "Toy Clojure in Java";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs =
    {
      self,
      nixpkgs,
      flake-utils,
    }:
    flake-utils.lib.eachDefaultSystem (
      system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
      in
      {
        devShells.default = pkgs.mkShell {
          buildInputs = with pkgs; [
            jdk25
            bazelisk
            just
            google-java-format
            (pkgs.writeShellScriptBin "bazel" "exec ${pkgs.bazelisk}/bin/bazelisk \"$@\"")
          ];

          shellHook = ''
            export JAVA_HOME="${pkgs.jdk25.home}"
          '';
        };
      }
    );
}
